package kots.threads;

class ThreadCreator extends Thread {

    private final int num;

    public ThreadCreator(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("Hello from Thread number " + num);
        if(num != 50) {
            final ThreadCreator threadCreator = new ThreadCreator(num + 1);
            threadCreator.start();
        }
    }
}
