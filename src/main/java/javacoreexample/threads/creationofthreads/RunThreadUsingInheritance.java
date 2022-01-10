package javacoreexample.threads.creationofthreads;

public class RunThreadUsingInheritance extends Thread {

    public RunThreadUsingInheritance() {

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

    }

    public static void startRunThreadUsingInheritance() {
        Thread thread = new Thread(new RunThreadUsingInheritance());
        thread.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
