package kots.multi.latch.homework;

import java.util.concurrent.CountDownLatch;

class Application {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);

        new RandomTimeTask(latch);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The latch has been closed");
    }
}
