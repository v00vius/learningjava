package utils.data;

import java.io.*;

public class FileDTO extends StringDTO {
private String fileName;

public FileDTO()
{
}

public DTO fromFile(String fileName)
{
        this.fileName = fileName;

        try (
                var fis = new FileInputStream(fileName);
                var isr = new InputStreamReader(fis);
                var is = new BufferedReader(isr);
        ) {
                var linesProcessed = is.lines()
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .filter(s -> '#' != s.charAt(0))
                        .peek(this::fromString)
                        .count();

        } catch (Exception e) {
                System.err.println("DTO::fromFile: " + e.getMessage());
        }

        return this;
}

public static void main(String[] args)
{
        FileDTO dto = new FileDTO();

        dto.fromFile("/home/vlan/IdeaProjects/learningjava/assignment/activity/filedto.txt");

        System.out.println("DTO: " + dto);
        System.out.println("boolean=" + dto.getBoolean("key2"));
}
}
