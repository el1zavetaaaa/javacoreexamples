package javacoreexample.threads.deadlocks;

public class Resource2 {
    Resource1 resource1;


    public synchronized int getResource() {
        return resource1.returnInt();
    }

    public synchronized int returnInt() {
        return 2;
    }
}
