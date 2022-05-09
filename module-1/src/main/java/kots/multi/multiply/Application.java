package kots.multi.multiply;

import java.util.Random;

class Application {

    public static final int ARRAY_LENGTH = 9;

    public static void main(String[] args) {
        int[] arrayOne = new int[ARRAY_LENGTH];
        int[] arrayTwo = new int[ARRAY_LENGTH];

        Random random = new Random();
        int one = random.nextInt(99) + 1;
        int two = random.nextInt(34) + 1;

        for(int i = 0; i < ARRAY_LENGTH; i++) {
            arrayOne[i] = one;
            arrayTwo[i] = two;
        }

        PartialCalc partialCalc = new PartialCalc(arrayOne, 5);
        PartialCalc partialCalc2 = new PartialCalc(arrayTwo, 4);

        partialCalc.run();
        partialCalc2.run();

        System.out.println("First sum: " + partialCalc.getSum());
        System.out.println("Second sum: " + partialCalc2.getSum());
    }
}
