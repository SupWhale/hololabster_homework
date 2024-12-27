package com.example.schedulemanage.entity;

import com.example.schedulemanage.controller.RunTask;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ProcessCreator implements Runnable {
    private final int processId;
    private int threadNumber;
    Task task = new Task();
    public ProcessCreator(int processId, int threadNumber) {
        this.processId = processId;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        try {
            // 프로세스를 생성합니다.
            String command = "java -cp . ProcessHandler " + processId;
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            Process process = processBuilder.start();

            System.out.println("Process " + processId + " started.");

            // 각 프로세스에서 스레드를 생성
            int numberOfThreads = threadNumber;  // 각 프로세스에서 생성할 스레드 수
            ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

            for (int i = 0; i < numberOfThreads; i++) {
                // 각 스레드가 계산한 합계를 프로세스로 전달
                executorService.submit(new ProcessHandlerThread(processId, i));
            }

            executorService.shutdown();
            while (!executorService.isTerminated()) {
                // 모든 스레드가 종료되기를 기다립니다.
            }

            //process.destroy();
            RunTask.processInfo += processId + "|" + "|" + RunTask.result +",";
            RunTask.statusNum += 1;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}