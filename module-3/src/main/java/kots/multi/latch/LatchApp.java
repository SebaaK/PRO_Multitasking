package kots.multi.latch;

import java.util.concurrent.CountDownLatch;

class LatchApp {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);

        new ExampleTask(latch);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The latch has been closed");
    }
}
