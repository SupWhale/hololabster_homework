package com.example.schedulemanage.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RequestTaskDto {
    private int processCount;
    private int threadCount;

    RequestTaskDto(int processCount, int threadCount){
        this.processCount = processCount;
        this.threadCount = threadCount;
    }

}
