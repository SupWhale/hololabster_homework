package com.example.schedulemanage.controller;


import com.example.schedulemanage.dto.RequestTaskDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ScheduleController {
    @GetMapping("/process/start") // 요청
    public int calculateProcessThread(@RequestBody RequestTaskDto requestTaskDto) {
        RunTask te = new RunTask();
       /* te.result = 0;
        te.processInfo = "";
        te.threadInfo = "";
        te.statusNum = 0;*/
        
        //db 연계시 프로세스와 스레드를 동시에 기록할 수 있음
        return te.RunTask(requestTaskDto.getProcessCount(), requestTaskDto.getThreadCount());
    }

    @GetMapping("/task/{task_id}") // 요청
    public RunTask SelectPageSchedule2(@PathVariable String task_id) {
        // db등을 연계하면 구현 가능
        RunTask te = new RunTask();
        return te;
    }
}
