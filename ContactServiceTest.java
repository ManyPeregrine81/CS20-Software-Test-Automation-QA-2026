package module6;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Data structure to store contacts by their unique ID
    private final Map<String, Contact> contacts = new HashMap<>();

    // Adds a new contact if the contact ID is unique
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        String contactId = contact.getContactId();

        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        contacts.put(contactId, contact);
    }

    // Deletes a contact based on the contact ID
    public void deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contacts.remove(contactId);
    }

    // Updates the first name of a contact
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContactById(contactId);
        contact.setFirstName(firstName);
    }

    // Updates the last name of a contact
    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContactById(contactId);
        contact.setLastName(lastName);
    }

    // Updates the phone number of a contact
    public void updatePhone(String contactId, String phone) {
        Contact contact = getContactById(contactId);
        contact.setPhone(phone);
    }

    // Updates the address of a contact
    public void updateAddress(String contactId, String address) {
        Contact contact = getContactById(contactId);
        contact.setAddress(address);
    }

    // Helper method to retrieve a contact or throw an exception if not found
    private Contact getContactById(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        return contacts.get(contactId);
    }
}