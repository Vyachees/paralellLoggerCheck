package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    static LogEntity logEntity;

    public static List<LogEntity> generate(){
        List<LogEntity>result = new ArrayList<>();
    for(int i=0;i<500000*10;i++){
        logEntity=LogEntity.builder()
                .id(i)
                .coord1(i+1)
                .coord2(i+2)
                .dateTime(LocalDateTime.now())
                .build();
        result.add(logEntity);
    }
    return  result;
}
}
