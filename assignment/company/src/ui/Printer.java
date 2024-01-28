package ui;

import dto.Registry;
import util.ConsoleIO;

public class Printer {
public static void printEmployees(Registry response, ConsoleIO io)
{
        printHeader(io);
        response.setTag("/employee");

        for (int i = 0, size = response.getInt("size"); i < size; ++i) {
                io.puts(String.format("%04d %20s %20s %20s %20s\n",
                                response.getInt("id", i),
                                response.get("firstName", i),
                                response.get("lastName", i),
                                response.get("jobPosition", i),
                                response.get("department", i)
                        )
                );
        }
}
public static void printEmployee(Registry response, ConsoleIO io)
{
        response.setTag("/employee");

        io.puts("The Employee\n");
        io.puts("            ID: " + response.getInt("id") + '\n');
        io.puts("    First Name: " + response.get("firstName") + '\n');
        io.puts("     Last Name: " + response.get("lastName") + '\n');
        io.puts("  Job Position: " + response.get("jobPosition") + '\n');
}
public static void printHeader(ConsoleIO io)
{
        io.puts("Employees\n");
        io.puts(String.format("%4s %20s %20s %20s %20s\n",
                        "ID",
                        "First Name",
                        "Last Name",
                        "Job Position",
                        "Department"
                )
        );

        io.puts(String.format("%4s %20s %20s %20s %20s\n",
                        "--",
                        "----------",
                        "---------",
                        "------------",
                        "----------"
                )
        );

}

}
