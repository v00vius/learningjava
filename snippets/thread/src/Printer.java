import java.util.concurrent.Semaphore;

public class Printer {
private final Semaphore access;

public Printer()
{
        access = new Semaphore(1);
}

public Printer begin()
{
        boolean tryAgain = true;

        while (tryAgain) {
                try {
                        access.acquire();
                        tryAgain = false;
                }
                catch (InterruptedException e) {
                        System.out.println("Got interrupted: " + e);
                        System.out.println("Retrying.");
                }
        }

        return this;
}
public Printer print(String s)
{
        System.out.println(s);

        return this;
}
public void end()
{
        access.release();
}

}
