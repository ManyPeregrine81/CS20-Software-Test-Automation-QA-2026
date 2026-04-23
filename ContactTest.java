package module6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContactSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "1234567890",
                "Ian",
                "Chattin",
                "1234567890",
                "123 First Street"
        );

        service.addContact(contact);

        // If no exception is thrown, the test passes
        assertTrue(true);
    }

    @Test
    void testAddDuplicateContactId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact(
                "1234567890",
                "Ian",
                "Chattin",
                "1234567890",
                "123 First Street"
        );
        Contact contact2 = new Contact(
                "1234567890",
                "Jennifer",
                "Navarro",
                "0987654321",
                "456 Second Street"
        );

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    void testDeleteContactSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "1234567890",
                "Ian",
                "Chattin",
                "1234567890",
                "123 First Street"
        );

        service.addContact(contact);
        service.deleteContact("1234567890");

        // If deletion succeeds without exception, test passes
        assertTrue(true);
    }

    @Test
    void testDeleteNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("9999999999");
        });
    }

    @Test
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "1234567890",
                "Ian",
                "Chattin",
                "1234567890",
                "123 First Street"
        );

        service.addContact(contact);
        service.updateFirstName("1234567890", "Jennifer");

        assertEquals("Jennifer", contact.getFirstName());
    }

    @Test
    void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "1234567890",
                "Ian",
                "Chattin",
                "1234567890",
                "123 First Street"
        );

        service.addContact(contact);
        service.updateLastName("1234567890", "Navarro");

        assertEquals("Navarro", contact.getLastName());
    }

    @Test
    void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "1234567890",
                "Ian",
                "Chattin",
                "1234567890",
                "123 First Street"
        );

        service.addContact(contact);
        service.updatePhone("1234567890", "0987654321");

        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "1234567890",
                "Ian",
                "Chattin",
                "1234567890",
                "123 First Street"
        );

        service.addContact(contact);
        service.updateAddress("1234567890", "456 Second Street");

        assertEquals("456 Second Street", contact.getAddress());
    }
}
