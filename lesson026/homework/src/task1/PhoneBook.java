package task1;

import java.util.Set;

public interface PhoneBook {
public Status addContact(Contact contact);
public Status removeContact(Contact contact);
public Set<Contact> getContacts();
public Contact getContactByName(String name);
public Contact getContactByPhoneNumber(String phoneNumber);

}
