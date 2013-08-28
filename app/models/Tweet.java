package models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author sondre
 */
@Entity
@JsonIgnoreProperties(value = {"replyTo"})
public class Tweet extends Model {

    @Id
    @GeneratedValue
    public long id;

    public String text;

    public String user;

    public String time;

    public static Finder<Long, Tweet> find = new Finder<>(Long.class, Tweet.class);

}
