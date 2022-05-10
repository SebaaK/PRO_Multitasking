package kots.multi.parallel;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

class CountriesApp {

    public static void main(String[] args) {
        List<Country> countries = Countries.randomCountries(193);

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        System.out.println("People on the world: " + forkJoinPool.invoke(new CountriesProcessTask(countries)));
    }
}
