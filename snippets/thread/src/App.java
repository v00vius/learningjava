import java.util.List;
import java.util.stream.IntStream;

public class App {
public static void main(String[] args)
{
        int maxThreads = Runtime.getRuntime().availableProcessors();

        System.out.println("availableProcessors: " + maxThreads);

        List<Thread> threads = IntStream.range(0, maxThreads)
                .peek(System.out::println)
                .mapToObj(i ->
                {
                        Runnable aTask = new Runnable() {
                                private String name = "worker" + i;

                                @Override
                                public void run()
                                {
                                        System.out.println("Running: " + name);
                                }
                        };

                        return new Thread(aTask);
                })
                .toList();

        System.out.println(threads);

        for (Thread th : threads) {
                System.out.println("The thread is about to start: name=" + th.getName()
                                        + " priority=" + th.getPriority()
                                        + " id=" + th.threadId());
                th.start();
        }

        for (Thread th : threads) {
                        try {
                                th.join();
                        } catch (InterruptedException e) {
                                System.out.println(e);

//                                throw new RuntimeException(e);
                        }
        }
        System.out.println("Done.");

//        long n = threads.stream()
//                .peek(thread ->
//                {
//                        System.out.println("The thread is about to start: name=" + thread.getName()
//                                                + " priority=" + thread.getPriority()
//                                                + " id=" + thread.threadId()
//                        );
//
//                        thread.start();
//                })
//                .count();
//
//        System.out.println(n);
//
//        n = threads.stream()
//                .peek(t ->
//                {
//                        try {
//                                t.join();
//                        } catch (InterruptedException e) {
//                                throw new RuntimeException(e);
//                        }
//                })
//                .count();
//        System.out.println(n);

}
}
