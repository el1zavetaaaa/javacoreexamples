package javacoreexample.threads.synchronization;

import java.util.Scanner;

public class Synchronization {
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. run synchronized method.");
            System.out.println("2. run synchronized String Buffer.");
            System.out.println("3. exit.");
            System.out.print("Please, enter the number:");
            int number;
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
            boolean shouldBreak = false;

            switch (number) {

                case (1):
                    synchronization();
                    break;
                case (2):
                    synchronizationOfString();
                    break;
                case (3):
                    shouldBreak = true;
                    System.out.println("Thank you for your attention!");
                    break;
            }
            if (shouldBreak) break;
        }
    }


    public static int counter;

    public static void synchronization() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    counter = 0;
                    for (int i = 0; i < 5; i++) {
                        counter = counter + 1;
                        System.out.println(Thread.currentThread().getName() + ":" + counter);
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void synchronizationOfString() {
        StringBuffer stringBuffer = new StringBuffer();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                stringBuffer
                        .append("long hello world long hello world long hello world long hello world long hello world long hello world long hello world from thread : ")
                        .append(Thread.currentThread().getName())
                        .append("\n");
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(stringBuffer);
    }

}
