package movie;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();
    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while(rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            //determine amounts for each line
            result += "\t" + each._movie.getMovie().getTitle() + "\t" + String.valueOf(each._movie.getCharge(each.getDaysRented())) + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public double getTotalCharge(){
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while(rentals.hasMoreElements()){
            Rental rental = (Rental) rentals.nextElement();
            result+= rental._movie.getCharge(rental.getDaysRented());
        }
        return result;
    }

    public double getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while(rentals.hasMoreElements()){
            Rental rental = (Rental) rentals.nextElement();
            result+=rental.getFrequentRenterPoints();
        }
        return result;
    }

}
