package kots.multi.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Countries {

    private Countries() {}

    public static List<Country> randomCountries(int number) {
        List<Country> countries = new ArrayList<>();
        Random random = new Random();
        for(int n = 0; n < number; n++) {
            countries.add(new Country("Country name " + n, random.nextInt((int) Math.pow(3, number))));
        }
        return countries;
    }
}
