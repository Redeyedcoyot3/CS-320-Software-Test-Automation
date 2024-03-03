import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
    /*
    Dylan Cavazos
    Project One
    Software Test Automation & QA
     */

public class ContactServiceTest {
    // private attribute contactService
    private ContactService contactService;

    // creates a new instance of Contact Service and assigns it to service before each test
    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    /*
    Created a test to test and retrieve each contact that's a new contact instance with superhero contact info.
    Then use assertEquals to verify new instance has been successfully retrieved.
    */
    @Test
    public void testAddAndRetrieveContact() {
        Contact contact = new Contact("1", "Peter", "Parker", "5551234567", "20 Test Street, Queens, NY");
        contactService.addContact(contact);
        Contact retrieved = contactService.getContact("1");
        assertNotNull(retrieved);
        assertEquals("Peter", retrieved.getFirstName());
        assertEquals("Parker", retrieved.getLastName());
        assertEquals("5551234567", retrieved.getPhone());
        assertEquals("20 Test Street, Queens, NY", retrieved.getAddress());
    }

    /*
    Created a test to check if adding a duplicate contact will throw an exception. If true, then exception is successfully thrown.
    If not, then output "Expected exception for duplicate ID"
    */
    @Test
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("2", "Bruce", "Wayne", "5559876543", "1007 Test Drive, Gotham");
        contactService.addContact(contact1);
        try {
            contactService.addContact(new Contact("2", "Bruce", "Wayne", "5559876543", "1007 Test Drive, Gotham"));
            fail("Expected IllegalArgumentException for duplicate contact ID");
        } catch (IllegalArgumentException ignored) {
            // Test passes if this exception is thrown
        }
    }

    /*
    Test to verify that a new contact instance is successfully deleted.
    Use assertNull to verify contact info is now set to null.
    */
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("3", "Clark", "Kent", "5557890123", "1938 Test Lane, Metropolis");
        contactService.addContact(contact);
        contactService.deleteContact("3");
        assertNull(contactService.getContact("3"));
    }

    /*
    Test to verify contact info is successfully updated to new contact info.
    */
    @Test
    public void testUpdateContactFirstName() {
        Contact contact = new Contact("3", "Clark", "Kent", "5557890123", "1938 Test Lane, Metropolis");
        contactService.addContact(contact);
        contactService.updateContactFirstName("3", "Bruce");
        Contact updated = contactService.getContact("3");
        assertNotNull(updated);
        assertEquals("Bruce", updated.getFirstName());
        assertEquals("Kent", updated.getLastName());
        assertEquals("5557890123", updated.getPhone());
        assertEquals("1938 Test Lane, Metropolis", updated.getAddress());
    }

    /*
    Test that checks if contact last name is successfully updated
     */
    @Test
    public void testUpdateContactLastName() {
        Contact contact = new Contact("3", "Clark", "Kent", "5557890123", "1938 Test Lane, Metropolis");
        contactService.addContact(contact);
        contactService.updateContactLastName("3", "Wayne");
        Contact updated = contactService.getContact("3");
        assertNotNull(updated);
        assertEquals("Clark", updated.getFirstName());
        assertEquals("Wayne", updated.getLastName());
        assertEquals("5557890123", updated.getPhone());
        assertEquals("1938 Test Lane, Metropolis", updated.getAddress());
    }

    /*
    Test that checks if contacts phone number is successfully updated
     */
    @Test
    public void testUpdateContactPhone() {
        Contact contact = new Contact("3", "Clark", "Kent", "5557890123", "1938 Test Lane, Metropolis");
        contactService.addContact(contact);
        contactService.updateContactPhone("3", "5551234567");
        Contact updated = contactService.getContact("3");
        assertNotNull(updated);
        assertEquals("Clark", updated.getFirstName());
        assertEquals("Kent", updated.getLastName());
        assertEquals("5551234567", updated.getPhone());
        assertEquals("1938 Test Lane, Metropolis", updated.getAddress());
    }

    /*
    Test that checks if contacts address is successfully updated
     */
    @Test
    public void testUpdateContactAddress() {
        Contact contact = new Contact("3", "Clark", "Kent", "5557890123", "1938 Test Lane, Metropolis");
        contactService.addContact(contact);
        contactService.updateContactAddress("3", "Daily Planet, Metropolis");
        Contact updated = contactService.getContact("3");
        assertNotNull(updated);
        assertEquals("Clark", updated.getFirstName());
        assertEquals("Kent", updated.getLastName());
        assertEquals("5557890123", updated.getPhone());
        assertEquals("Daily Planet, Metropolis", updated.getAddress());
    }
/*
Test that tries to delete a contact that doesn't exist.
 */
    @Test
    public void testDeleteNonExistingContact() {
        try {
            contactService.deleteContact("nonexistent");
            fail("Expected IllegalArgumentException for nonexistent contact");
        } catch (IllegalArgumentException e) {
            // Test passes if IllegalArgumentException is thrown
        }
    }




}
