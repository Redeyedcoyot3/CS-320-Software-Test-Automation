import java.util.HashMap;
import java.util.Map;
    /*
    Dylan Cavazos
    Project One
    Software Test Automation & QA
     */
public class ContactService {
    /*
    Using map instead of Array List to increase efficiency of complexity.
     */
    private final Map<String, Contact> contacts = new HashMap<>();

    // method to check if contact is already included in contact list, if not then add it.
    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Invalid or Duplicate Contact");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Find the contact and check if null and does not exist. If not, then remove it from contact list
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact does not exist");
        }
        contacts.remove(contactId);
    }

    // Update the first name of a contact
    public void updateContactFirstName(String contactId, String firstName) {
        Contact contact = findContactById(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact does not exist");
        }
        contact.setFirstName(firstName);
    }

    // Update the last name of a contact
    public void updateContactLastName(String contactId, String lastName) {
        Contact contact = findContactById(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact does not exist");
        }
        contact.setLastName(lastName);
    }

    // Update the phone number of a contact
    public void updateContactPhone(String contactId, String phone) {
        Contact contact = findContactById(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact does not exist");
        }
        contact.setPhone(phone);
    }

    // Update the address of a contact
    public void updateContactAddress(String contactId, String address) {
        Contact contact = findContactById(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact does not exist");
        }
        contact.setAddress(address);
    }

    // Method to get the contact from parameter contactId info and return it.
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    // Find the contact by ID in the Map
    private Contact findContactById(String contactId) {
        return contacts.get(contactId);
    }
}
