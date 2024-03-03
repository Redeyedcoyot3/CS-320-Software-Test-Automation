import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
    /*
    Dylan Cavazos
    Project One
    Software Test Automation & QA
     */
public class ContactTest {

    /*
    Test that verifies a contact is successfully created using a new instance.
    Use assertEquals to verify contact is successfully implemented.
    */
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1", "Peter", "Parker", "5551234567", "20 Test Street, Queens, NY");
        assertNotNull(contact);
        assertEquals("Peter", contact.getFirstName());
        assertEquals("Parker", contact.getLastName());
        assertEquals("5551234567", contact.getPhone());
        assertEquals("20 Test Street, Queens, NY", contact.getAddress());
    }

    /*
    Test that checks for incorrect conditions for contact generation.
    If contact parameters are outside boundary conditions then output IllegalArgumentException.
    */
    @Test
    public void testInvalidContactId() {
        try {
            new Contact(null, "Bruce", "Wayne", "5559876543", "1007 Test Drive, Gotham");
            fail("Expected IllegalArgumentException for null contactId");
        } catch (IllegalArgumentException ignored) {}

        try {
            new Contact("12345678901", "Clark", "Kent", "5557890123", "1938 Test Lane, Metropolis");
            fail("Expected IllegalArgumentException for too long contactId");
        } catch (IllegalArgumentException ignored) {}
    }

    /*
    Test that checks the first name is valid in contact instance.
    If value is outside boundary condition, catch illegal argument exception.
    */
    @Test
    public void testInvalidFirstName() {
        try {
            new Contact("2", null, "Wayne", "5559876543", "1007 Test Drive, Gotham");
            fail("Expected IllegalArgumentException for null firstName");
        } catch (IllegalArgumentException ignored) {}

        try {
            new Contact("3", "Superman", "Kent Clarks", "5557890123", "1938 Test Lane, Metropolis");
            fail("Expected IllegalArgumentException for too long firstName");
        } catch (IllegalArgumentException ignored) {}
    }

    /*
    Test the mutators and accessors successfully retrieve or modify information from instance contact object.
    Use assertEquals.
    */
    @Test
    public void testSettersAndGetters() {
        Contact contact = new Contact("2", "Bruce", "Wayne", "5559876543", "1007 Test Drive, Gotham");
        contact.setFirstName("Batman");
        contact.setLastName("DarkKnight");
        contact.setPhone("5550000000");
        contact.setAddress("Batcave, Gotham");

        assertEquals("Batman", contact.getFirstName());
        assertEquals("DarkKnight", contact.getLastName());
        assertEquals("5550000000", contact.getPhone());
        assertEquals("Batcave, Gotham", contact.getAddress());
    }

    /*
    Test that verifies exception is thrown when mutators pass in values outside legal boundary conditions for contact instance.
    Catches illegal argument exception when null is passed in for values or values are outside required boundary conditions.
    */
    @Test
    public void testInvalidSetters() {
        Contact contact = new Contact("1", "Bruce", "Wayne", "5559876543", "1007 Test Drive, Gotham");

        try {
            contact.setFirstName(null);
            fail("Expected IllegalArgumentException for null firstName");
        } catch (IllegalArgumentException ignored) {}

        try {
            contact.setLastName(null);
            fail("Expected IllegalArgumentException for null lastName");
        } catch (IllegalArgumentException ignored) {}

        try {
            contact.setPhone("111");
            fail("Expected IllegalArgumentException for invalid phone");
        } catch (IllegalArgumentException ignored) {}

        try {
            contact.setAddress(null);
            fail("Expected IllegalArgumentException for null address");
        } catch (IllegalArgumentException ignored) {}

        try {
            contact.setAddress("The Batcave  beneath Wayne Manor, Gotham City, is definitely way too long to be valid");
            fail("Expected IllegalArgumentException for too long address");
        } catch (IllegalArgumentException ignored) {}
    }

}
