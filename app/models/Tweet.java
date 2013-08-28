package models;

import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author sondre
 */
@Entity
public class Tweet extends Model {

    @Id
    @GeneratedValue
    public long id;

    public String message;

    public String user;

    @Formats.DateTime(pattern = "E MMM dd HH:mm:ss Z yyyy")
    public Date time;

    public static Finder<Long, Tweet> find = new Finder<>(Long.class, Tweet.class);

}
