package contacts.service;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Add contact with unique ID
    public void addContact(Contact contact) {
        if (contact == null || !contact.validateContactId() || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Invalid contact or duplicate contact ID");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete contact per contact ID
    public void deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }

    // Update contact fields per contact ID
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        if (firstName != null && firstName.length() <= 10) {
            contact.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() <= 10) {
            contact.setLastName(lastName);
        }
        if (phone != null && phone.matches("\\d{10}")) {
            contact.setPhone(phone);
        }
        if (address != null && address.length() <= 30) {
            contact.setAddress(address);
        }
    }

    // Retrieve all contacts
    public Map<String, Contact> getContacts() {
        return new HashMap<>(contacts);
    }
}

