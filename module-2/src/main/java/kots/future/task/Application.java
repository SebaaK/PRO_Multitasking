package kots.future.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static kots.util.SleepUtil.sleep;

class Application {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Future<Integer> process1 = new Process().process(10);
        final Future<Integer> process2 = new Process().process(5);

        while(!process1.isDone() && !process2.isDone()) {
            if(process1.isDone())
                System.out.println("Process 1 is done");
            else if(process2.isDone())
                System.out.println("Process 2 is done");
            else
                System.out.println("Process still working");
            sleep(1);
        }

        System.out.println("Result! \nProcess1: " + process1.get() + "\nProcess2: " + process2.get());
    }
}
