package kots.multi.multiply;

public class PartialCalc implements Runnable {

    private int[] elements;
    private int multiplyBy;
    private int sum;

    public PartialCalc(int[] elements, int multiplyBy) {
        this.elements = elements;
        this.multiplyBy = multiplyBy;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        for(int i = 0; i < elements.length; i++) {
            sum += elements[i] * multiplyBy;
        }
    }
}
