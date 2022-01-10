package javacoreexample.threads.deadlocks;

public class Resource1 {
    Resource2 resource2;

    public synchronized int getResource() {

        return resource2.returnInt();
    }

    public synchronized int returnInt() {
        return 1;
    }

}
