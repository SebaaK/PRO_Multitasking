package kots.multi.download;

import java.util.Random;
import java.util.concurrent.Semaphore;

class DownloadManager implements Runnable {

    private static int counter;
    private static Semaphore semaphore = new Semaphore(10);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            download();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void download() throws InterruptedException {
        Random random = new Random();
        synchronized (DownloadManager.class) {
            counter++;
            System.out.println("There is/are " + counter + " download file");
        }
        Thread.sleep(random.nextInt(10000));
        synchronized (DownloadManager.class) {
            counter--;
        }
    }
}
