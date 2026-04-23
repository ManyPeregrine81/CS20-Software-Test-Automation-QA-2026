package module6;

//Class representing a Contact with basic information
public class Contact {

 // Unique identifier for the contact (cannot be changed once set)
 private final String contactId;
 
 // Contact's first name
 private String firstName;
 
 // Contact's last name
 private String lastName;
 
 // Contact's phone number (must be 10 digits)
 private String phone;
 
 // Contact's address
 private String address;
 
 public Contact(String contactId, String firstName, String lastName, String phone, String address) {

     // Validate contactId
     if (contactId == null || contactId.length() > 10) {
         throw new IllegalArgumentException("Invalid contact ID");
     }

     // Validate firstName
     if (firstName == null || firstName.length() > 10) {
         throw new IllegalArgumentException("Invalid first name");
     }

     // Validate lastName
     if (lastName == null || lastName.length() > 10) {
         throw new IllegalArgumentException("Invalid last name");
     }

     // Validate phone number (must be 10 digits)
     if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
         throw new IllegalArgumentException("Invalid phone number");
     }

     // Validate address
     if (address == null || address.length() > 30) {
         throw new IllegalArgumentException("Invalid address");
     }

     // Assign values to instance variables
     this.contactId = contactId;
     this.firstName = firstName;
     this.lastName = lastName;
     this.phone = phone;
     this.address = address;
 }

 // Getter for contactId (read-only)
 public String getContactId() {
     return contactId;
 }

 // Getter for firstName
 public String getFirstName() {
     return firstName;
 }

 // Setter for firstName with validation
 public void setFirstName(String firstName) {
     if (firstName == null || firstName.length() > 10) {
         throw new IllegalArgumentException("Invalid first name");
     }
     this.firstName = firstName;
 }

 // Getter for lastName
 public String getLastName() {
     return lastName;
 }

 // Setter for lastName with validation
 public void setLastName(String lastName) {
     if (lastName == null || lastName.length() > 10) {
         throw new IllegalArgumentException("Invalid last name");
     }
     this.lastName = lastName;
 }

 // Getter for phone number
 public String getPhone() {
     return phone;
 }

 // Setter for phone number with validation
 public void setPhone(String phone) {
     if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
         throw new IllegalArgumentException("Invalid phone number");
     }
     this.phone = phone;
 }

 // Getter for address
 public String getAddress() {
     return address;
 }

 // Setter for address with validation
 public void setAddress(String address) {
     if (address == null || address.length() > 30) {
         throw new IllegalArgumentException("Invalid address");
     }
     this.address = address;
 }
}