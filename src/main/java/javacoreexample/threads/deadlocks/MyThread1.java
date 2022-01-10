package javacoreexample.threads.deadlocks;

public class MyThread1 extends Thread {
    Resource1 resource1;

    @Override
    public void run() {
        System.out.println(resource1.getResource());
    }
}
