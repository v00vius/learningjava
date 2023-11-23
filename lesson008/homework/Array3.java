

public class Array3 {
    static
    public String[] text = {
            " What is Multithreading? ",
            "  ",
            " Multithreading is a programming concept in which the application can create a small unit of tasks to execute in parallel. If you are working on a computer, it runs multiple applications and allocates processing power to them. A simple program runs in sequence and the code statements execute one by one. This is a single-threaded application. But, if the programming language supports creating multiple threads and passes them to the operating system to run in parallel, it’s called multithreading. ",
            " Multithreading vs Multiprocessing ",
            "  ",
            " When we talk about multithreading, we don’t care if the machine has a 2-core processor or a 16-core processor. Our work is to create a multithreaded application and let the OS handle the allocation and execution part. In short, multithreading has nothing to do with multiprocessing. ",
            " How does Java Support Multithreading? ",
            "  ",
            " Java has great support for multithreaded applications. Java supports multithreading through Thread class. Java Thread allows us to create a lightweight process that executes some tasks. We can create multiple threads in our program and start them. Java runtime will take care of creating machine-level instructions and work with OS to execute them in parallel. ",
            " What are the different types of threads? ",
            "  ",
            " There are two types of threads in an application - user thread and daemon thread. When we start an application, the main is the first user thread created. We can create multiple user threads as well as daemon threads. When all the user threads are executed, JVM terminates the program. ",
            " What is Thread Priority? ",
            "  ",
            " When we create a thread, we can assign its priority. We can set different priorities to different Threads but it doesn’t guarantee that a higher priority thread will execute first than a lower priority thread. The thread scheduler is the part of Operating System implementation and when a Thread is started, its execution is controlled by Thread Scheduler and JVM doesn’t have any control over its execution. ",
            " How Do we Create Thread in Java? ",
            "  ",
            " We can create Threads by either implementing Runnable interface or by extending Thread Class. "
    };

    public static void main(String[] args) {
        DynamicStringArray words1 = new DynamicStringArray();
        DynamicStringArray words2 = new DynamicStringArray();

        for (int i = 0; i < text.length; i++) {
            String line = text[i].trim();

            if (line.isEmpty())
                continue;

            //System.out.println("Line #" + i + " " + line);

            String[] lineWords = line.split(" ");

            for (int j = 0; j < lineWords.length; j++) {
                String word = lineWords[j];

                //System.out.println("\t" + j + ") \"" + word + "\"");

                if (word.length() % 2 == 0)
                    words2.add(word);
                else
                    words1.add(word);
            }
        }

        System.out.println("An array of words with an ODD length of a word ("
                + words1.getSize() + " words)");
        System.out.println(words1);

        System.out.println("An array of words with an EVEN length of a word ("
                + words2.getSize() + " words)");
        System.out.println(words2);
    }
}

