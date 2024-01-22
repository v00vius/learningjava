package task1;


import java.util.Objects;

public class Contact implements Comparable<Contact> {
private final String name;
private String phoneNumber;

public Contact(String name, String phoneNumber)
{
        this.name = name;
        this.phoneNumber = phoneNumber;
}

public String getName()
{
        return name;
}

public String getPhoneNumber()
{
        return phoneNumber;
}

@Override
public int compareTo(Contact o)
{
        int rc1 = getName().compareTo(o.getName());
        int rc2 = getPhoneNumber().compareTo(o.getPhoneNumber());

        if(rc1 == 0 || rc2 == 0)
                return 0;

        return rc1;
}

@Override
public int hashCode()
{
        return 31;
}

@Override
public boolean equals(Object o)
{
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;

        return name.equals(contact.name) || phoneNumber.equals(contact.phoneNumber);
}

@Override
public String toString()
{
        return "Contact{" +
               "name='" + name + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               '}';
}
}
