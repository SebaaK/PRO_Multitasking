package kots.multi.exchanger.homework;

import java.util.concurrent.Exchanger;

class Application {

    public static void main(String[] args) {
        Exchanger<Book> exchanger = new Exchanger<>();

        new BookConsumer(exchanger);
        new BookProducer(exchanger);
    }
}
