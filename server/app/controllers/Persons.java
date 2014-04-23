package controllers;

import com.google.gson.Gson;
import models.Person;
import play.Logger;
import play.data.binding.ParamNode;
import play.db.jpa.GenericModel;
import play.db.jpa.JPABase;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Http;

import java.util.List;

/**
 *
 */
public class Persons extends AbstractController {

    public static final Gson GSON = new Gson();

    public static void query() {
        List<Person> all = Person.findAll();
        renderJSON(all);
    }

    public static void get(Long id) {
        Person person = Person.findById(id);
        notFoundIfNull(person);
        renderJSON(person);
    }

    public static void save() {
        Person incoming = GSON.fromJson(params.get("body"), Person.class);
        Person merged = incoming.merge();
        if(merged.validateAndSave()){
            renderJSON(merged);
        } else {
            error(validation.errorsMap().toString());
        }
    }

    public static void delete(Long id) {
        Person person = Person.findById(id);
        notFoundIfNull(person);
        person.delete();
        ok();
    }

}
