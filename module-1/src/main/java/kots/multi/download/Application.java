package kots.multi.download;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Application {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int n = 0; n < 1000; n++) {
            executor.submit(new DownloadManager());
        }
        executor.shutdown();
    }
}
