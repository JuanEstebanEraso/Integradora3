package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Premium extends User {
    ArrayList <Book> booksPurchased= new ArrayList<>();
    ArrayList <Magazine> subscribedMagazines= new ArrayList<>();
    private String creditCard;
    public Premium(String name,String id, LocalDate vinculationDate,String creditCard) {
    super(name,id,vinculationDate);
    this.creditCard=creditCard;
    
} 
  
public String getCreditCard() {
    return creditCard;
}

public void setCreditCard(String creditCard) {
    this.creditCard = creditCard;
}
public String buyBibliographic(Book book) {
    booksPurchased.add(book);
    return "You bought a book";
}



@Override
public ArrayList<Bibliographicproduct> getPurchasedProducts() {
    return purchasedProducts;
}

@Override
public String showReadingSession(String name) {
	
	ReadingSession readingSession = getReadingSessionByName(name);
	return readingSession.toString();
	}
}

