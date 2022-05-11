package kots.counter;

class CounterApp {

    private static volatile int counter = 0;

    public static void main(String[] args) {
        final Thread listener = createListener();
        final Thread changer = createChanger();

        listener.start();
        changer.start();
    }

    private static Thread createChanger() {
        return new Thread(() -> {
            int localValue = counter;
            while(counter < 5) {
                System.out.println("Incrementing counter to " + (counter + 1));
                counter = ++localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static Thread createListener() {
        return new Thread(() -> {
            int localValue = counter;
            while(localValue < 5) {
                if(localValue != counter) {
                    System.out.println("Received coutner change: " + counter);
                    localValue = counter;
                }
            }
        });
    }
}
