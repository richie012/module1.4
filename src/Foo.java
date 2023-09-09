import java.util.concurrent.Semaphore;

public class Foo {
    private Semaphore semaphoreFirst;
    private Semaphore semaphoreSecond;

    public Foo() {
        semaphoreFirst = new Semaphore(0);
        semaphoreSecond = new Semaphore(0);
    }

    public void first() {
        System.out.print("first");
        semaphoreFirst.release();
    }

    public void second() throws InterruptedException {
        semaphoreFirst.acquire();
        System.out.print("second");
        semaphoreSecond.release();
    }

    public void third() throws InterruptedException {
        semaphoreSecond.acquire();
        System.out.print("third");
    }

}
