package models

import org.specs2.mutable.Specification
import play.api.test.WithApplication
import java.util.Date

/**
 *
 * @author sondre
 */
class TweetSpecTest extends Specification {

  "Creating a new tweet with id=1 and saving it" should {
    "should make it available for search" in new WithApplication {
       val tweet = new Tweet;
       tweet.id = 1;
       tweet.message = "message"
       tweet.user = "user"
       tweet.time = new Date
       tweet.save()
       Tweet.find.byId(1) mustEqual tweet
    }
  }

}
