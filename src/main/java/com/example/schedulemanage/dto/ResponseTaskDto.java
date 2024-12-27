package com.example.schedulemanage.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTaskDto {
    private String status;
    private String task_id;
    private int resultValue;

    ResponseTaskDto (String status, String task_id, int resultValue){
        this.status = status;
        this.task_id = task_id;
        this.resultValue = resultValue;
    }
}
