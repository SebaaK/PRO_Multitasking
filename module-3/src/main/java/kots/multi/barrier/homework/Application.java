package kots.multi.barrier.homework;

import java.util.concurrent.CyclicBarrier;

class Application {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, new FinalStep());

        for(int n = 0; n < 5; n++) {
            new PartialStep(barrier);
        }
    }
}
