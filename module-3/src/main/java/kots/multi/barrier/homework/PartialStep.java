package kots.multi.barrier.homework;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

class PartialStep implements Runnable {
    private final CyclicBarrier barrier;
    private int sumaA = 1000;
    private int sumaB = 0;

    public PartialStep(CyclicBarrier barrier) {
        this.barrier = barrier;
        new Thread(this).start();
    }

    @Override
    public void run() {
        int cycleCount = 0;
        Random random = new Random();
        while(sumaA > sumaB) {
            sumaA += random.nextInt(9);
            sumaB += random.nextInt(49);
            cycleCount++;
            System.out.println(
                    "CycleCount: " + cycleCount +
                    "\nSumaA: " + sumaA +
                    "\nSumaB: " + sumaB + "\n"
            );
        }
    }
}
