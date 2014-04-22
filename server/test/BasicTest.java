import models.Person;
import org.junit.Test;
import play.test.UnitTest;

public class BasicTest extends UnitTest {

    @Test
    public void createAndRetrieveUser() {
        // Create a new user and save it
        new Person("interesting article", "content Haha").save();

        // Retrieve the user with e-mail address person@gmail.com
        Person person = Person.find("byTitle", "interesting article").first();

        // Test
        assertNotNull(person);
        assertEquals("content Haha", person.content);
    }
}
