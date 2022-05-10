package kots.lock;

import java.util.Random;

import static kots.util.SleepUtil.sleep;

class RemoveProductWorker implements Runnable {

    private final String workerName;
    private final LockedWarehouse warehouse;

    public RemoveProductWorker(String workerName, LockedWarehouse warehouse) {
        this.workerName = workerName;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        sleep(3);
        final int id = new Random().nextInt(3);

        switch(id) {
            case 0:
                warehouse.remove(Product.BOOK, workerName);
                break;
            case 1:
                warehouse.remove(Product.ELECTRONICS, workerName);
                break;
            case 3:
                warehouse.remove(Product.TOYS, workerName);
        }
    }
}
