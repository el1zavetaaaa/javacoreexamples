package javacoreexample.threads.creationofthreads;

public class RunThreadUsingInterfaceRunnable implements Runnable {

    public RunThreadUsingInterfaceRunnable() {

    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void startRunThreadUsingInterfaceRunnable() {
        Thread thread = new Thread(new RunThreadUsingInterfaceRunnable());
        thread.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
