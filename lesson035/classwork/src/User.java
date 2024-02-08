import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class User {
private int id;
private String name;
private String description;

public User(int id, String name, String description)
{
        this.id = id;
        this.name = name;
        this.description = description;
}

@Override
public String toString()
{
        return "[User]\n" +
                "id=" + id + '\n' +
                "name=" + name + '\n' +
                "description=" + description + '\n';
}

static public int save(List<User> users, String toFile) throws IOException
{
        FileWriter fw = new FileWriter(toFile);
        BufferedWriter writer = new BufferedWriter(fw);

        int count = 0;

        for (User u : users) {
                writer.write(u.toString());
                count++;
        }

        writer.close();

        return count;
}

public static void main(String[] args) throws IOException
{
        System.out.println("# Creating users");
        List<User> users = IntStream.range(1, 11)
                .mapToObj(id -> new User(id, "Name-" + id, "Description-" + id))
                .toList();

        System.out.println("# " + users.size() + " users created");
//        System.out.println(users);

        String outputFile = "/home/vlan/tmp/UserData_id.txt";

        int saved = save(users, outputFile);

        System.out.println("# File '" + outputFile + "', saved " + saved + " users");
}
}
