package com.example.schedulemanage.controller;

import com.example.schedulemanage.entity.ProcessCreator;

public class RunTask {
    public static int result = 0;
    public static int statusNum = 0;
    public int process_count=0;
    public int threads_per_process=0;
    public String status="";
    public static int total_sum = 0;

    public static String threadInfo = "";
    public static String processInfo = "";

    /*public static void main(String[] args) {
        int numberOfProcesses = 3;  // 생성할 프로세스 수
        int threadNumber = 2;
        for (int i = 0; i < numberOfProcesses; i++) {
            // 각 프로세스를 생성하는 작업
            new Thread(new ProcessCreator(i, threadNumber)).start();
        }
    }*/

    public int RunTask(int process, int thread) {
        int numberOfProcesses = process;  // 생성할 프로세스 수
        int threadNumber = thread;
        this.result = 0;
        this.processInfo = "";
        this.threadInfo = "";
        this.statusNum = 0;
        for (int i = 0; i < numberOfProcesses; i++) {
            // 각 프로세스를 생성하는 작업
            new Thread(new ProcessCreator(i, threadNumber)).start();
        }


        while(this.statusNum != numberOfProcesses){
           System.out.println("..........");
        }


        System.out.println("process : "+this.processInfo);
        System.out.println("thread : "+this.threadInfo);

        return this.result;
    }
}
   /* public static class ProcessCreator implements Runnable {
        private final int processId;

        public ProcessCreator(int processId, int threadNumber) {
            this.processId = processId;
        }

        @Override
        public void run() {
            try {
                // 프로세스를 생성합니다.
                String command = "java -cp . ProcessHandler " + processId;
                ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
                Process process = processBuilder.start();

                System.out.println("Process " + processId + " started.");

                // 각 프로세스에서 스레드를 2개 생성
                int numberOfThreads = 2;  // 각 프로세스에서 생성할 스레드 수
                ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

                for (int i = 0; i < numberOfThreads; i++) {
                    // 각 스레드가 계산한 합계를 프로세스로 전달
                    executorService.submit(new ProcessHandlerThread(processId, i));
                }
                executorService.shutdown();
                while (!executorService.isTerminated()) {
                    // 모든 스레드가 종료되기를 기다립니다.
                }

                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

   /* static class ProcessHandlerThread implements Runnable {
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
                result += sum;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}*/
