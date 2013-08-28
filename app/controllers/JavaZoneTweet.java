package controllers;

import models.Tweet;
import org.codehaus.jackson.JsonNode;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.tweets;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sondre
 */
public class JavaZoneTweet extends Controller {

    public static Result findJavaZoneTweets() {

        return async(WS.url("http://javabin.zapodot.org/twitter/search/javazone").get().map(new F.Function<WS.Response, Result>() {
            @Override
            public Result apply(WS.Response response) throws Throwable {
                final JsonNode jsonNode = response.asJson();
                List<Tweet> tweetsList = new LinkedList<>();
                final Iterator<JsonNode> jsonElements = jsonNode.getElements();
                while (jsonElements.hasNext()) {
                    tweetsList.add(Json.fromJson(jsonElements.next(), Tweet.class));
                }
                return ok(tweets.render("Tweets", tweetsList));
            }
        }));
    }
}
