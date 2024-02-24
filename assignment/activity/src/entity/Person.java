package entity;

import java.util.List;
import java.util.UUID;

public class Person {
private UUID id;
private String name;
private String login;
private String  passwdHash;
private List<Task> tasks;

public Person()
{
}
public Person(String name, String login)
{
        this.name = name;
        this.login = login;
}
public void setId(UUID id)
{
        this.id = id;
}
public void setName(String name)
{
        this.name = name;
}
public void setLogin(String login)
{
        this.login = login;
}
public void setPasswdHash(String passwdHash)
{
        this.passwdHash = passwdHash;
}
public UUID getId()
{
        return id;
}
public String getName()
{
        return name;
}
public String getLogin()
{
        return login;
}
public String getPasswdHash()
{
        return passwdHash;
}
}
