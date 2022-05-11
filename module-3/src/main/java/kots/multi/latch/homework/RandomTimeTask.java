package kots.multi.latch.homework;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

class RandomTimeTask implements Runnable {

    private CountDownLatch latch;

    public RandomTimeTask(CountDownLatch latch) {
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
        Random random = new Random();
        int randomInt = random.nextInt(1500) + 500;
        System.out.println("Running task with " + randomInt);
        try {
            sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
