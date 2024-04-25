package contacts.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contacts.service.Contact;

public class ContactTest {

    @Test
    public void testContactIdLength() {
        // Test if contact ID is not longer than 10 characters
        Contact contact = new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        assertFalse(contact.validateContactId());
    }

    @Test
    public void testContactIdNotNull() {
        // Test if contact ID is not null
        Contact contact = new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        assertFalse(contact.validateContactId());
    }

    @Test
    public void testContactIdNotUpdatable() {
        // Test if contact ID is not updatable
        Contact contact = new Contact("oldId", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(UnsupportedOperationException.class, () -> {
            contact.setContactId("newId");
        });
    }

    @Test
    public void testFirstNameLength() {
        // Test if first name is not longer than 10 characters
        Contact contact = new Contact("12345", "Johnathan", "Doe", "1234567890", "123 Main St");
        assertTrue(contact.validateFirstName());
    }

    @Test
    public void testFirstNameNotNull() {
        // Test if first name is not null
        Contact contact = new Contact("12345", null, "Doe", "1234567890", "123 Main St");
        assertFalse(contact.validateFirstName());
    }

    @Test
    public void testLastNameLength() {
        // Test if last name is not longer than 10 characters
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(contact.validateLastName());
    }

    @Test
    public void testLastNameNotNull() {
        // Test if last name is not null
        Contact contact = new Contact("12345", "John", null, "1234567890", "123 Main St");
        assertFalse(contact.validateLastName());
    }

    @Test
    public void testPhoneValid() {
        // Test if phone number is valid
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(contact.validatePhone());
    }

    @Test
    public void testPhoneInvalid() {
        // Test if phone number is invalid
        Contact contact = new Contact("12345", "John", "Doe", "12345", "123 Main St");
        assertFalse(contact.validatePhone());
    }

    @Test
    public void testAddressLength() {
        // Test if address is not longer than 30 characters
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St, Apartment 100, Some very very very very very Long Address That Exceeds 30 Characters");
        assertFalse(contact.validateAddress());
    }

    @Test
    public void testAddressNotNull() {
        // Test if address is not null
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", null);
        assertFalse(contact.validateAddress());
    }
}
