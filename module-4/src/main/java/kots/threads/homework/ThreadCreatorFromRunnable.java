package kots.threads.homework;

class ThreadCreatorFromRunnable implements Runnable {

    private final int number;

    public ThreadCreatorFromRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Hello from Thread number " + number);
        if(number != 50) {
            Thread thread = new Thread(new ThreadCreatorFromRunnable(number + 1));
            thread.start();
        }
    }
}
