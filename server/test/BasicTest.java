import models.Person;
import org.junit.Test;
import play.test.UnitTest;

public class BasicTest extends UnitTest {

    @Test
    public void createAndRetrieveUser() {
        // Create a new user and save it
        new Person("John", 18).save();

        // Retrieve the user with e-mail address person@gmail.com
        Person person = Person.find("byName", "John").first();

        // Test
        assertNotNull(person);
        assertEquals(Integer.valueOf(18), person.age);
    }
}
