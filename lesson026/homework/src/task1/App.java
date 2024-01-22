package task1;

public class App {
public static void main(String[] args)
{
        PhoneBook contacts = ContactManager.create();
        Contact contact1;
        Contact contact2;
        Status status;

        contact1 = new Contact("Oliver", "100-12-67");
        contact2 = new Contact("Ellis", "100-13-68");

        status = contacts.addContact(contact1);
        System.out.println(status);

        status = contacts.addContact(contact2);
        System.out.println(status);

        status = contacts.addContact(contact2);
        System.out.println(status);

        status = contacts.addContact(new Contact("Oscar", "100-13-68"));
        System.out.println(status);

        status = contacts.addContact(new Contact("Henry", "100-13-00"));
        System.out.println(status);

        System.out.println(contacts);

        status = contacts.getContactByPhoneNumber("100");
        System.out.println(status);

        status = contacts.getContactByName("li");
        System.out.println(status);

        status = contacts.removeContact(contact1);
        System.out.println(status);
        System.out.println(contacts);
}
}
