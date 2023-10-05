package org.example;


import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
       // System.out.println("Hello world!");
        List<LogEntity> logEntityList = DataGenerator.generate();

        //ParalellLogger paralellLogger = new ParalellLogger(); //1 000 000 6207mills
        //paralellLogger.paralellCalc(logEntityList);
//Paralell retrieved 5000000 objects in 28177 milliseconds


        OneThreadLogger oneThreadLogger = new OneThreadLogger();// 1 000 000 4010mils
        oneThreadLogger.oneThreadCalc(logEntityList);
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
