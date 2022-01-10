package javacoreexample.threads.deadlocks;

public class DeadLocks {
    public static void main(String[] args) {
        Resource1 resource1 = new Resource1();
        Resource2 resource2 = new Resource2();

        resource2.resource1 = resource1;
        resource1.resource2 = resource2;

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.resource1 = resource1;
        myThread2.resource2 = resource2;

        myThread1.start();
        myThread2.start();

    }
}
