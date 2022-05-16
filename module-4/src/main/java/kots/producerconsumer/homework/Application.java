package kots.producerconsumer.homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Application {

    public static int READ_TIME = 500;
    public static int WRITE_TIME = 500;

    public static void main(String[] args) {
        Database database = new Database();
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int n = 0; n < cores; n++) {
            executorService.submit(new Producer(database));
            executorService.submit(new Consumer(database));
        }
        executorService.shutdown();
    }
}
