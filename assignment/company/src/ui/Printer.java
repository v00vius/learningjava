package ui;

import dto.Registry;
import util.ConsoleIO;

public class Printer {
public static void printEmployees(Registry response, ConsoleIO io)
{
        printHeader(io);
        response.setTag("/employee");

        for (int i = 0, size = response.getInt("size"); i < size; ++i) {
                io.puts(String.format("%20s %20s %20s %20s\n",
                                response.get("firstName", i),
                                response.get("lastName", i),
                                response.get("jobPosition", i),
                                response.get("department", i)
                        )
                );
        }
}
public static void printHeader(ConsoleIO io)
{
        io.puts("Employees\n");
        io.puts(String.format("%20s %20s %20s %20s\n",
                        "First Name",
                        "Last Name",
                        "Job Position",
                        "Department"
                )
        );

        io.puts(String.format("%20s %20s %20s %20s\n",
                        "----------",
                        "---------",
                        "------------",
                        "----------"
                )
        );

}

}
