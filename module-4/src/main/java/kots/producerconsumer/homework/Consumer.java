package kots.producerconsumer.homework;

import java.util.Random;

import static kots.producerconsumer.homework.Application.READ_TIME;

class Consumer implements Runnable {

    private final Database database;

    public Consumer(Database database) {
        this.database = database;
    }

    @Override
    public void run() {
        int counter = 0;
        final Random random = new Random();
        try {
            while(counter < 5) {
                database.select();
                Thread.sleep(random.nextInt(READ_TIME));
                counter++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
