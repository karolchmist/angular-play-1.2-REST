package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 *
 */
@Entity
public class Person extends Model {

    @Required
    public String name;
    @Required
    public Integer age;

    @Lob
    public String content;

    public Person() {
    }

    public Person(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }
}
