package kots.multi.multiply.multipleArrays;

import java.util.Arrays;

public class SampleCalc implements Runnable {

    private int[] firstElements;
    private int[] secondElements;
    private long[] resultElements;

    public SampleCalc(int[] firstElements, int[] secondElements) {
        this.firstElements = firstElements;
        this.secondElements = secondElements;
        resultElements = new long[firstElements.length];
    }

    private void multipleArrays() {
        for(int i = 0; i < firstElements.length; i++) {
            resultElements[i] = (long) firstElements[i] * secondElements[i];
        }
    }

    @Override
    public void run() {
        multipleArrays();
        System.out.println(Thread.currentThread().getName() + " finished. Result: " + Arrays.toString(resultElements));
    }
}
