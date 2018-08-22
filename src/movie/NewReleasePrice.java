package movie;

public class NewReleasePrice extends Price {
    @Override
    double getPriceCode(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode(daysRented) == Movie.NEW_RELEASE) && daysRented > 1) return 2;
        return 1;
    }
}
