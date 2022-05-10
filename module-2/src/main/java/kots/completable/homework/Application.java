package kots.completable.homework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static kots.util.SleepUtil.sleep;

class Application {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Book book1 = new Book("Airstream", "Motorbooks", 2018);
        Book book2 = new Book("Supercars", "Motorbooks", 2016);

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Finding books...");
            sleep(5);
            CompletableFuture<String> future1 = book1.makeSignatureAndShowBookInfo("BestSignature");
            CompletableFuture<String> future2 = book2.makeSignatureAndShowBookInfo("NewSignature");
            try {
                sleep(2);
                return future1.get() + "\n" + future2.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Books: \n" + completableFuture.get());
    }
}
