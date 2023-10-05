package org.example;

import java.util.List;

public class OneThreadLogger {
    long oneThreadCalc(List<LogEntity> arrayList){
        long startTime = System.currentTimeMillis();
        for(LogEntity logEntity:arrayList){
            System.out.println(logEntity);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime=endTime-startTime;
        System.out.println("Onethread retrieved "+arrayList.size()+" objects in " + elapsedTime + " milliseconds");
        return endTime-startTime;
    }
}
