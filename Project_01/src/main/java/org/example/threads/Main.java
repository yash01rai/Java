package org.example.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {

            NumberPrinter numberPrinter = new NumberPrinter(i);

            executorService.execute(numberPrinter);

//            Thread t = new Thread(numberPrinter);
//
//            t.start();
        }

        System.out.println("Cores " + cores);

    }
}