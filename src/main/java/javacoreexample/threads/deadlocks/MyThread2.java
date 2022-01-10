package javacoreexample.threads.deadlocks;

public class MyThread2 extends Thread {
    Resource2 resource2;

    @Override
    public void run() {
        System.out.println(resource2.getResource());
    }
}
