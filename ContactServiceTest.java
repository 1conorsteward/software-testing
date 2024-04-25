package contacts.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contacts.service.Contact;
import contacts.service.ContactService;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertTrue(contactService.getContacts().containsKey("1234567890"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        assertFalse(contactService.getContacts().containsKey("1234567890"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Jane", null, "0987654321", null);
        Contact updatedContact = contactService.getContacts().get("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("123 Main St", updatedContact.getAddress());
    }
}
