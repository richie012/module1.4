public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread firstThread = new Thread(() -> {
            foo.first();
        });

        Thread secondThread = new Thread(() -> {
            try {
                foo.third();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread thirdThread = new Thread(() -> {
            try {
                foo.second();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        
        firstThread.start();
        secondThread.start();
        thirdThread.start();

    }
}