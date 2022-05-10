package kots.multi.parallel;

class Country {

    private final String name;
    private long peopleQuantity;

    public Country(String name, long peopleQuantity) {
        this.name = name;
        this.peopleQuantity = peopleQuantity;
    }

    public long getPeopleQuantity() {
        return peopleQuantity;
    }
}
