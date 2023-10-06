package org.example;


import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {

       // System.out.println("Hello world!");
        final List<LogEntity> logEntityList = DataGenerator.generate();

        final ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        new Thread(new Runnable() {
            public void run() {
                String s;
                while( !Thread.currentThread().isInterrupted() ) {
                    while ((s = concurrentLinkedQueue.poll()) != null) {
                        System.out.println(s);
                    }
                }
            }
        }).start();

        ParalellLogger paralellLogger = new ParalellLogger(); //1 000 000 6207mills
        paralellLogger.paralellCalc(logEntityList, concurrentLinkedQueue);
//Paralell retrieved 5000000 objects in 28177 milliseconds


        //OneThreadLogger oneThreadLogger = new OneThreadLogger();// 1 000 000 4010mils
        //oneThreadLogger.oneThreadCalc(logEntityList);
//nethread retrieved 5000000 objects in 19795 milliseconds

        /*long start = System.currentTimeMillis();
        for(LogEntity logEntity : logEntityList){
            System.out.println(logEntity);
        }
        long end = System.currentTimeMillis();
        System.out.println("===================");
        System.out.println("duration mills = "+(end-start));*/
    }

}
