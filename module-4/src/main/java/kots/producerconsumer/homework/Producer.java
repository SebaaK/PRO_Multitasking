package kots.producerconsumer.homework;

import java.util.Random;

import static kots.producerconsumer.homework.Application.READ_TIME;
import static kots.producerconsumer.homework.Application.WRITE_TIME;

class Producer implements Runnable {

    private final Database database;

    public Producer(Database database) {
        this.database = database;
    }

    @Override
    public void run() {
        int counter = 0;
        final Random random = new Random();
        try {
            while(counter < 5) {
                database.insert();
                Thread.sleep(random.nextInt(WRITE_TIME));
                counter++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
