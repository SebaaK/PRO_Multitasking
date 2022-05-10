package kots.multi.parallel;

import java.util.List;
import java.util.concurrent.RecursiveTask;

class CountriesProcessTask extends RecursiveTask<Long> {

    private List<Country> countries;

    public CountriesProcessTask(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    protected Long compute() {
        if(countries.size() <= 5)
            return countries.stream()
                    .mapToLong(Country::getPeopleQuantity)
                    .sum();
        else {
            int middle = countries.size() / 2;
            CountriesProcessTask left = new CountriesProcessTask(countries.subList(0, middle));
            CountriesProcessTask right = new CountriesProcessTask((countries.subList(middle, countries.size())));
            left.fork();
            Long rightResult = right.compute();
            Long leftResult = left.join();

            return leftResult + rightResult;
        }
    }
}
