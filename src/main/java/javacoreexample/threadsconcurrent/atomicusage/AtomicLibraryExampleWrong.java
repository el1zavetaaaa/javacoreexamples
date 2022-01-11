package javacoreexample.threadsconcurrent.atomicusage;

import java.util.ArrayList;
import java.util.List;

public class AtomicLibraryExampleWrong {

    private static int counter = 0;

    private static int nextInt() {
        return counter++;
    }

    public static void main(String[] args) throws Exception {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; ++i) {
            Thread thread = new Thread(() -> System.out.println(nextInt()));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Counter final value: " + counter);
    }
}
