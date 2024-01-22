package task1;

import java.util.Set;

public interface PhoneBook {
public Status addContact(Contact contact);
public Status removeContact(Contact contact);
public Set<Contact> getContacts();
public Status getContactByName(String name);
public Status getContactByPhoneNumber(String phoneNumber);
}
