package kots.completable.homework;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static kots.util.SleepUtil.sleep;

class Book {

    private String title;
    private String author;
    private int year;
    private String signature;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public CompletableFuture<String> makeSignatureAndShowBookInfo(String newSignature) {
        return CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            System.out.println("Prepare to show book with title: " + title);
            sleep(random.nextInt(10));
             signature = newSignature;
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", year=" + year +
                    ", signature='" + signature + '\'' +
                    '}';
        });
    }
}
