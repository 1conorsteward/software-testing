package contacts.service;

public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructors
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters and setters
    public String getContactId() {
        return contactId;
    }

    // Contact ID is not updatable
    public void setContactId(String contactId) {
        // Contact ID is not updatable
        throw new UnsupportedOperationException("Contact ID is not updatable");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        // Validate phone number format before setting
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Validation methods
    public boolean validateContactId() {
        return contactId != null && contactId.length() <= 10;
    }

    public boolean validateFirstName() {
        return firstName != null && !firstName.isEmpty() && firstName.length() <= 10;
    }

    public boolean validateLastName() {
        return lastName != null && !lastName.isEmpty() && lastName.length() <= 10;
    }

    public boolean validatePhone() {
        return phone != null && phone.matches("\\d{10}");
    }

    public boolean validateAddress() {
        return address != null && !address.isEmpty() && address.length() <= 30;
    }
}
