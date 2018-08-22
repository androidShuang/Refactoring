package movie;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    Price price;

    public Movie(String title, int priceCode){
        _title = title;
        setPriceCode(priceCode);
    }

    public Price getPriceCode() {
        return price;
    }

    public void setPriceCode(int arg) {
        switch (arg){
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("error argument");
        }
    }

    public String getTitle() {
        return _title;
    }

    public Movie getMovie() {
        return this;
    }

    double getCharge(int daysRented) {
        return price.getPriceCode(daysRented);
    }

}
