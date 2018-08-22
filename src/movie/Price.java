package movie;

public abstract class Price {
    abstract double getPriceCode(int days);

    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
