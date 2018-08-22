package movie;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode){
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public String getTitle() {
        return _title;
    }

    // jjhou add
    public static void main(String[] args) {
        System.out.println("Refactoring, a First Example, step1");

        Movie m1 = new Movie("Seven", Movie.NEW_RELEASE);
        Movie m2 = new Movie("Terminator", Movie.REGULAR);
        Movie m3 = new Movie("Star Trek", Movie.CHILDRENS);

        Rental r1 = new Rental(m1, 4);
        Rental r2 = new Rental(m1, 2);
        Rental r3 = new Rental(m3, 7);
        Rental r4 = new Rental(m2, 5);
        Rental r5 = new Rental(m3, 3);

        Customer c1 = new Customer("jjhou");
        c1.addRental(r1);
        c1.addRental(r4);

        Customer c2 = new Customer("gigix");
        c2.addRental(r1);
        c2.addRental(r3);
        c2.addRental(r2);

        Customer c3 = new Customer("jiangtao");
        c3.addRental(r3);
        c3.addRental(r5);

        Customer c4 = new Customer("yeka");
        c4.addRental(r2);
        c4.addRental(r3);
        c4.addRental(r5);

        System.out.println(c1.statement());
        System.out.println(c2.statement());
        System.out.println(c3.statement());
        System.out.println(c4.statement());
    }

    public Movie getMovie() {
        return this;
    }

    double getCharge(int daysRented) {
        double thisAmount = 0;
        switch(getPriceCode()){
            case REGULAR:
                thisAmount += 2;
                if((daysRented)>2)
                    thisAmount += (daysRented-2)*1.5;
                break;

            case NEW_RELEASE:
                thisAmount += daysRented*3;
                break;

            case CHILDRENS:
                thisAmount += 1.5;
                if(daysRented >3)
                    thisAmount += (daysRented-3)*1.5;
                break;
        }
        return thisAmount;
    }

    int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) return 2;
        return 1;
    }

}
