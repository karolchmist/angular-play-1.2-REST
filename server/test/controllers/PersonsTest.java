package controllers;

import com.google.gson.*;
import models.Person;
import org.junit.*;
import play.db.jpa.GenericModel;
import play.db.jpa.JPA;
import play.db.jpa.JPABase;
import play.mvc.Http;
import play.test.Fixtures;
import play.test.FunctionalTest;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: karol
 * Date: 4/23/14
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */

public class PersonsTest extends FunctionalTest {

    @Before
    public void setUp() {
        Fixtures.deleteAllModels();
        Fixtures.loadModels("initial-data.yml");
    }

    @After
    public void tearDown() {
        Fixtures.deleteAllModels();
    }

    @Test
    public void testGetAll() {
        Http.Response response = GET("/persons");
        assertIsOk(response);

        assertContentType("application/json", response);
        assertContentMatch("Karol", response);

        JsonElement list = getJson(response);
        assertEquals(list.getAsJsonArray().size(), 2);
    }

    @Test
    public void testDelete() {
        List<Person> all = Person.findAll();
        Person person = Person.find("byName", "Karol").first();

        Http.Response response = DELETE("/persons/" + person.id);
        assertIsOk(response);

        assertNull(Person.findById(1L));
    }

    @Test
    public void testCreate() {
        Http.Response response = POST("/persons", "application/json", "{name:'Skywalker', age:22}");
        assertIsOk(response);
        JsonElement content = new Gson().fromJson(getContent(response), JsonElement.class);

        Person person = Person.findById(Long.valueOf(content.getAsJsonObject().get("id").getAsLong()));
        assertNotNull(person);
        assertEquals("Skywalker", person.name);
        assertEquals(Integer.valueOf(22), person.age);
    }

    @Test
    public void testUpdate() throws InterruptedException {
        Person existing = Person.find("byName", "Karol").first();
        existing.age = 666;
        Http.Response response = POST("/persons", "application/json", new Gson().toJson(existing));
        assertIsOk(response);

        JPA.em().flush();

        Person person = Person.findById(existing.id);
        assertNotNull(person);
        assertEquals("Karol", person.name);
        assertEquals(Integer.valueOf(666), person.age);
    }

    private JsonElement getJson(Http.Response response) {
        String content = getContent(response);
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(content, JsonElement.class);
    }

}
