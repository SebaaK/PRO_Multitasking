package kots.multi.exchanger;

import java.util.concurrent.Exchanger;

class ExchangerProducer implements Runnable {

    private Exchanger<String> exchanger;

    public ExchangerProducer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for(int n = 0; n < 10; n++) {
            try {
                exchanger.exchange("Message number: " + n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
