package lesson;

import java.util.Scanner;

public class LessonVolatile {
    public static void main(String[] args) {
        MyThreadVolatile myThreadVolatile = new MyThreadVolatile();
        myThreadVolatile.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThreadVolatile.shutdown();
    }
}

class MyThreadVolatile extends Thread{
    //Cache Coherency
    private volatile boolean running = true;
    public void run(){
        while (running){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown(){
        this.running = false;
    }
}
