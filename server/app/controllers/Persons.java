package controllers;

import models.Person;
import play.data.binding.ParamNode;
import play.mvc.Controller;

/**
 *
 */
public class Persons extends Controller {

    public static void get(Long id) {
        Person person = Person.findById(id);
        notFoundIfNull(person);
        renderJSON(person);
    }

    public static void create() {
        Person person = Person.create("name", params);
        if(person.validateAndSave()){
            renderJSON(person.id);
        } else {
            error(validation.errorsMap().toString());
        }
    }
    public static void update(Long id) {
        Person person = Person.findById(id);
        person.edit(ParamNode.convert(params.all()), "person");
        validation.valid(person);
        if(validation.hasErrors()) {
            error(validation.errorsMap().toString());
        } else{
            person.save(); // explicit save here
            ok();
        }
    }
    public static void delete(Long id) {
        Person person = Person.findById(id);
        notFoundIfNull(person);
        person.delete();
        ok();
    }
}
