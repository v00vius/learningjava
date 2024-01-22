package task1;


import java.util.Objects;

public class Contact implements Comparable<Contact>{
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
        int rc = getName().compareTo(o.getName());

        return rc == 0 ? getPhoneNumber().compareTo(o.getPhoneNumber()) : rc;
}

@Override
public int hashCode()
{
        return Objects.hash(getName(), getPhoneNumber());
}

@Override
public boolean equals(Object o)
{
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;

        return name.equals(contact.name) && phoneNumber.equals(contact.phoneNumber);
}
}
