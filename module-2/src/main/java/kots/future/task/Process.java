package kots.future.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static kots.util.SleepUtil.sleep;

class Process {

    public Future<Integer> process(int taskId) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        return executorService.submit(() -> {
            System.out.println("Process with task " + taskId + " started processing");
            sleep(taskId * 5);
            System.out.println("Process with task " + taskId + " end processing");
            return taskId;
        });
    }
}
