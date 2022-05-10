package kots.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static kots.util.SleepUtil.sleep;

class Processor {

    public Future<Integer> process(int x) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        return executorService.submit(() -> {
            System.out.println("Processor started processing");
            sleep(5);
            System.out.println("Processor ended processing");
            return x * 1000;
        });
    }
}
