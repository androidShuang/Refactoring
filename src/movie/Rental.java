package movie;


//租赁
public class Rental {
    Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    double getCharge(){
        return _movie.getCharge(_daysRented);
    }

    int getFrequentRenterPoints(){
        return _movie.getPriceCode().getFrequentRenterPoints(_daysRented);
    }

}
