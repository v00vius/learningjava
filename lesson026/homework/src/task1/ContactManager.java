package task1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ContactManager implements PhoneBook {
private Set<Contact> phoneBook;

static public ContactManager create()
{
        return new ContactManager();
}

@Override
public String toString()
{
        return "ContactManager{" +
               "phoneBook=" + phoneBook +
               '}';
}

private ContactManager()
{
        phoneBook = new HashSet<>();
}

@Override
public Status addContact(Contact contact)
{
        boolean rc = phoneBook.add(contact);

        if(rc)
                return new Status(Status.OK, contact, "OK");

        return new Status(Status.ERROR, contact, "Contact or phone \""
                                         + contact.getName() + "\" already exists"
        );
}

@Override
public Status removeContact(Contact contact)
{
        boolean rc = phoneBook.remove(contact);

        if(rc)
                return new Status(Status.OK, contact, "OK");

        return new Status(Status.ERROR, contact, "Contact \"" + contact.getName() + "\" is unknown");
}

@Override
public Set<Contact> getContacts()
{
        return phoneBook;
}

@Override
public Status getContactByName(String name)
{
        return select(new ByName(name));
}
@Override
public Status getContactByPhoneNumber(String phoneNumber)
{
        return select(new ByPhone(phoneNumber));
}
private Status select(Comparator cmp)
{
        List<Contact> matches = new LinkedList<>();

        for(Contact e : phoneBook) {
                if(cmp.match(e))
                        matches.add(e);
        }

        if(matches.isEmpty())
                return new Status(Status.ERROR, cmp.getName(), "\"" + cmp.getName() + "\" not found");

        return new Status(Status.OK, matches, "OK");
}
}
