package kots.multi.parallel;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

class FormJoinApp {

    public static void main(String[] args) {
        List<Book> books = Books.randomBooks(1000);

        ForkJoinPool thePool = new ForkJoinPool();

        System.out.println(thePool.invoke(new BookProcessTask(books)));
    }
}
