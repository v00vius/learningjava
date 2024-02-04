import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class App {
public static void main(String[] args)
{
        int maxThreads = Runtime.getRuntime().availableProcessors();
        Printer out = new Printer();
        CyclicBarrier barrier = new CyclicBarrier(maxThreads, () ->{
                System.out.println("\n# CyclicBarrier: " + maxThreads + " thread(s) all they done");
        });


        System.out.println("# AvailableProcessors: " + maxThreads);

        List<Thread> threads = IntStream.range(0, maxThreads)
                .peek(System.out::println)
                .mapToObj(i ->
                {
                        Runnable aTask = () ->
                        {
                                Thread t = Thread.currentThread();
                                String aName = t.getName();

                                out.begin()
                                        .print("\n" + aName + ": " + t.getClass())
                                        .print(aName + ": ID " + t.threadId())
                                        .print(aName + ": priority " + t.getPriority());

                                for (int j = 0; j < 5; j++) {
                                        out.print(aName + ": data=" + j);

                                        try {
                                                Thread.sleep(100);
                                        } catch (InterruptedException e) {
                                                out.print("#Got: " + e);
                                        }
                                }

                                out.end();

                                try {
                                        System.out.println(t.getName() + ": done, awaiting...");
                                        barrier.await();
                                } catch (InterruptedException |
                                         BrokenBarrierException e) {
                                        System.out.println("# Got: " + e);
                                }

                                System.out.println(t.getName() + ": exiting ...");
                        };

                        return new Thread(aTask, "worker" + i);
                })
                .toList();

        System.out.println(threads);


        for (Thread th : threads) {
                System.out.println("# The thread is about to start: \n#  name " + th.getName()
                                        + "\n#  priority " + th.getPriority()
                                        + "\n#  id " + th.threadId());
                th.start();
        }

        for (Thread th : threads) {
                try {
                        th.join();
                } catch (InterruptedException e) {
                        System.out.println("# Got: " + e);
                }
        }

        System.out.println("\n# Test: Done.");

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
