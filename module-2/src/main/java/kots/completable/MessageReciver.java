package kots.completable;

import java.util.concurrent.CompletableFuture;

import static kots.util.SleepUtil.sleep;

class MessageReciver {

    public CompletableFuture<String> receive() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Waiting for message...");
            sleep(5);
            return "Hello";
        });
    }
}
