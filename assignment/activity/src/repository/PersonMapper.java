package repository;

import entity.Person;
import dto.DTO;
import storage.Mapper;
import dto.StringDTO;
import java.util.UUID;

public class PersonMapper implements Mapper<Person> {
@Override
public Person mapToObject(String str)
{
        DTO dto = new StringDTO(str);
        var person = new Person();

        UUID id = dto.getId("id");
        String name = dto.get("name");
        String login = dto.get("login");
        String passwd = dto.get("passwd_hash");

        person.setId(id);
        person.setName(name);
        person.setLogin(login);
        person.setPasswdHash(passwd);

        return person;
}

@Override
public String mapToString(Person person)
{
        DTO dto = new StringDTO();

        dto.set("id", person.getId())
                .set("name", person.getName())
                .set("login", person.getLogin())
                .set("passwd_hash", person.getPasswdHash());

        return dto.toString();
}
}
