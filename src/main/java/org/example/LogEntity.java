package org.example;

import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;

@Builder
@Data
public class LogEntity {
    private long id;
    private float coord1;
    private float coord2;
    LocalDateTime dateTime;

    @Override
    public String toString() {
        return "\n"+
                "LogEntity{" +
                "id=" + id +
                ", coord1=" + coord1 +
                ", coord2=" + coord2 +
                ", dateTime=" + dateTime +
                '}'+"\n";
    }
}
