package kots.multi.phaser;

import java.util.concurrent.Phaser;

class PhaserApp {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int phaseNum = phaser.getPhase();

        new PhasedTask(phaser, 0);
        new PhasedTask(phaser, 1);
        new PhasedTask(phaser, 1);
        new PhasedTask(phaser, 1);
        new PhasedTask(phaser, 1);

        System.out.println("Phase " + phaseNum + " - begin");

        phaser.arriveAndAwaitAdvance();
        phaseNum = phaser.getPhase();
        System.out.println("Phase " + phaseNum + " - reached");

        phaser.arriveAndAwaitAdvance();
        phaseNum = phaser.getPhase();
        System.out.println("Phase " + phaseNum + " - reached");

        phaser.arriveAndAwaitAdvance();
        phaseNum = phaser.getPhase();
        System.out.println("Phase " + phaseNum + " - reached");

        phaser.arriveAndDeregister();
        if(phaser.isTerminated())
            System.out.println("Work is finished!");


    }
}
