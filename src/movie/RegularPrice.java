package movie;

public class RegularPrice extends Price {
    @Override
    double getPriceCode(int daysRented) {
        double thisAmount = 2;
        if ((daysRented) > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
    }
}
