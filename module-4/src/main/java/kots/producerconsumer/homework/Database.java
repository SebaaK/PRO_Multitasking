package kots.producerconsumer.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Database {

    private List<Customer> customers = new ArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock writeLock = lock.writeLock();
    private final Lock readLock = lock.readLock();
    private final Condition bufferWrite = writeLock.newCondition();

    public void insert() {
        try {
            while(writeLock.tryLock()) {
                System.out.println("[WRITE] Waiting to unlock...");
                bufferWrite.await();
            }
            writeLock.lock();
            int randomInt = new Random().nextInt();
            Customer customer = new Customer("FirstName #" + randomInt, "LastName #" + randomInt);
            customers.add(customer);
            System.out.println("[WRITE] Added to collection new " + customer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
          writeLock.unlock();
          bufferWrite.signalAll();
        }
    }

    public void select() {
        try {
            while(readLock.tryLock()) {
                System.out.println("[READ] Waiting to unlock...");
                bufferWrite.await();
            }
            readLock.lock();
            final Random random = new Random();
            int randomInt = random.nextInt(customers.size());
            Customer customer = customers.get(randomInt);
            System.out.println("[READ] Remove from collection: " + customer);
            customers.remove(randomInt);
            bufferWrite.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            bufferWrite.signal();
        }
    }
}
