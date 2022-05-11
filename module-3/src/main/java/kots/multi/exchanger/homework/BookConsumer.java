package kots.multi.exchanger.homework;

import java.util.concurrent.Exchanger;

class BookConsumer implements Runnable {

    private Exchanger<Book> exchanger;

    public BookConsumer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            System.out.println(exchanger.exchange(null));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
