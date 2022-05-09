package kots.multi.multiply.multipleArrays;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Application {

    public static final int ARRAY_LENGHT = 100;

    public static void main(String[] args) {
        int[] firstElements = new int[ARRAY_LENGHT];
        int[] secondElements = new int[ARRAY_LENGHT];
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);

        for(int i = 0; i < ARRAY_LENGHT; i++) {
            firstElements[i] = i;
            secondElements[i] = i * i;
        }

        for(int n = 0; n < cores; n++) {
            executorService.submit(new SampleCalc(firstElements, secondElements));
        }
        executorService.shutdown();
    }
}
