package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class ArrayListReader implements Runnable {
    private List<LogEntity> arrayList;
    private final int startIndex;
    private final int endIndex;
    private CountDownLatch latch;
    final ConcurrentLinkedQueue<String> concurrentLinkedQueue;

    public ArrayListReader(List<LogEntity> arrayList, int startIndex, int endIndex,CountDownLatch latch, ConcurrentLinkedQueue<String> concurrentLinkedQueue) {
        this.arrayList = arrayList;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.latch=latch;
        this.concurrentLinkedQueue = concurrentLinkedQueue;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            //System.out.println(arrayList.get(i));
            concurrentLinkedQueue.add(arrayList.get(i).toString());
        }
        latch.countDown();
    }
}
