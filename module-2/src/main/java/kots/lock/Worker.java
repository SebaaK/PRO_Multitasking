package kots.lock;

import java.util.Random;

import static kots.util.SleepUtil.sleep;

class Worker implements Runnable {

    private final String workerName;
    private final LockedWarehouse warehouse;

    public Worker(String workerName, LockedWarehouse warehouse) {
        this.workerName = workerName;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        sleep(1);
        final Random random = new Random();
        final int id = random.nextInt(3);

        switch(id) {
            case 0:
                warehouse.add(Product.BOOK, workerName);
                break;
            case 1:
                warehouse.add(Product.ELECTRONICS, workerName);
                break;
            default:
                warehouse.add(Product.TOYS, workerName);
        }
    }
}
