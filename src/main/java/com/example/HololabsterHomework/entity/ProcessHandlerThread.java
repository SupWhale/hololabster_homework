package com.example.HololabsterHomework.entity;

import com.example.HololabsterHomework.controller.RunTask;

public class ProcessHandlerThread implements Runnable {
    private final int processId;
    private final int threadId;

    public ProcessHandlerThread(int processId, int threadId) {
        this.processId = processId;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        // 1부터 100까지 숫자를 더하는 작업
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        // 계산된 합계를 프로세스로 전달
        try {
            System.out.println("Running in process " + processId + " Runign in trehd" + threadId + " and : " + sum);
            RunTask.result += sum;
            RunTask.threadInfo += processId + "|" + threadId + "|" + sum +",";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}