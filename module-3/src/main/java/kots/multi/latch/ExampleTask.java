package kots.multi.latch;

import java.util.concurrent.CountDownLatch;

class ExampleTask implements Runnable {

    private CountDownLatch latch;

    public ExampleTask(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for(int n = 0; n < 5; n++) {
            doTask();
        }
    }

    private void doTask() {
        System.out.println("Running the task");
        latch.countDown();
    }
}
