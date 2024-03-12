package org.example;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;

public class MultiThreadSum {
    static long sum1 = 0;
    static long sum2 = 0;

    static long threadTime1 = 0;
    static long threadTime2 = 0;

    public static void main(String[] args) throws InterruptedException {
        int[] numbers = new int[10000000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        long startTime = System.currentTimeMillis();


        Thread thread1 = new Thread(() -> {
            //String thread_name = Thread.currentThread().getName();
            for (int i = 0; i < numbers.length / 2; i++) {
                sum1 += numbers[i];
            }
            long endTime = System.currentTimeMillis();

            // todo: Dodaj zliczanie czasu ile czasu spędzliśmy w tym wątku
            threadTime1 = endTime - startTime;
            print_process_info();
        });

        Thread thread2 = new Thread(() -> {
            //String thread_name = Thread.currentThread().getName();
            for (int i = numbers.length / 2; i < numbers.length; i++) {
                sum2 += numbers[i];
            }
            long endTime = System.currentTimeMillis();

            // todo: Dodaj zliczanie czasu ile czasu spędzliśmy w tym wątku
            threadTime2 = endTime - startTime;
            print_process_info();
        });


        thread1.start();
        thread1.setPriority(MAX_PRIORITY);
        thread2.start();
        thread2.setPriority(MIN_PRIORITY);

        thread1.join();
        thread2.join();

        long totalSum = sum1 + sum2;
        long endTime = System.currentTimeMillis();

        System.out.println("Suma: " + totalSum);
        long mainThreadTime = (endTime - startTime);
        System.out.println("Czas wykonania (dwa wątki): " + mainThreadTime + "ms");

        // todo: Pokaż ile czasu spedziliśmy w posczególnych wątkach
        // todo: Czy suma czasów wykonywania się poszczególnych wątków daje sumę wykonywania się całego procesu głównego?
        // todo: innymi słowy: Czy mainThreadTime == thread1Time + thread2Time + ... + threadNTime?

        System.out.println("Czas wykonania watku 1: " + threadTime1 + " ms");
        System.out.println("Czas wykonania watku 2: " + threadTime2 + " ms");


    }

    static void print_process_info()
    {
        System.out.println(ProcessHandle.current().pid());
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
    }
}
