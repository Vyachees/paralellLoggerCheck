package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParalellLogger {

    long paralellCalc(List<LogEntity> arrayList) {
        //List<LogEntity> arrayList = new ArrayList<>(); // Assuming your ArrayList is already populated
        int numThreads = Runtime.getRuntime().availableProcessors(); // Retrieve the number of available processors

        int objectsPerThread = arrayList.size() / numThreads; // Divide the total objects evenly among threads

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        CountDownLatch latch = new CountDownLatch(numThreads);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * objectsPerThread;
            int endIndex = (i + 1) * objectsPerThread;

            executor.execute(new ArrayListReader(arrayList, startIndex, endIndex,latch));
        }

        executor.shutdown();

        try {
            latch.await(); // Wait until all threads have counted down the latch
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("===========================");
        System.out.println("Paralell retrieved "+arrayList.size()+" objects in " + elapsedTime + " milliseconds");
        return elapsedTime;
    }
}
