package kots.multi.exchanger.homework;

import java.util.Random;
import java.util.concurrent.Exchanger;

class BookProducer implements Runnable {

    private Exchanger<Book> exchanger;

    public BookProducer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        int randomInt = new Random().nextInt(1000);
        try {
            exchanger.exchange(new Book(
                    "Title number " + randomInt,
                    "Author number " + randomInt
            ));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
