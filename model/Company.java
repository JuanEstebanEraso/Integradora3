package model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;




public class Company{
	
    ArrayList <User> ussers= new ArrayList<>();
    ArrayList <Bibliographicproduct> bibliographicproducts= new ArrayList<>();

    ArrayList<Book> puschasedBooks = new ArrayList<>();
    ArrayList<Magazine> purchasesMagazines = new ArrayList<>();

    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private String nameCompany;
   
    public Company(String nameCompany){
        this.nameCompany=nameCompany;
        
    }
    public void generateTestCases(){
        Regular user1 = new Regular("pipe","1234",LocalDate.now());
        Premium user2=new Premium("juan","1212",LocalDate.now(),"1293ss");

        Book book1=new Book("comunismo",40,LocalDate.now(),"https//:",2000.0,"hambre",1);
        Book book2=new Book("cien años de soledad",20,LocalDate.now(),"https//:",3000.0,"Colombia",1);
        Book book3=new Book("el principito",30,LocalDate.now(),"https//:",4000.0,"niño",1);
        Book book4=new Book("ww2",40,LocalDate.now(),"https//:",5000.0,"bombas",1);
        Book book5=new Book("el hombre y la mujer",50,LocalDate.now(),"https//:",6000.0,"niño",1);
     
        Magazine magazine1 =new Magazine("soho",20,LocalDate.now(),"https//:",1000.0,"diary",1);
        Magazine magazine2 =new Magazine("times",30,LocalDate.now(),"https//:",2000.0,"diary",1);
        Magazine magazine3 =new Magazine("el quiubo",40,LocalDate.now(),"https//:",3000.0,"diary",1);
        Magazine magazine4 =new Magazine("ciencia",50,LocalDate.now(),"https//:",4000.0,"diary",1);
        Magazine magazine5 =new Magazine("marca",60,LocalDate.now(),"https//:",5000.0,"diary",1);
        
        ussers.add(user1);
        ussers.add(user2);
        bibliographicproducts.add(book1);
        bibliographicproducts.add(book2);
        bibliographicproducts.add(book3);
        bibliographicproducts.add(book4);
        bibliographicproducts.add(book5);
        
        bibliographicproducts.add(magazine1);
        bibliographicproducts.add(magazine2);
        bibliographicproducts.add(magazine3);
        bibliographicproducts.add(magazine4);
        bibliographicproducts.add(magazine5);
        
    }
    public void saleAutomatic(){
        for (int i = 0; i < 30; i++) {
        ussers.get(1).addPurchasedProduct(bibliographicproducts.get(1));
        // ussers.get(1).addPurchasedProduct(bibliographicproducts.get(2));
        // ussers.get(1).addPurchasedProduct(bibliographicproducts.get(3));
        // ussers.get(1).addPurchasedProduct(bibliographicproducts.get(4));
        // ussers.get(1).addPurchasedProduct(bibliographicproducts.get(5));
        // ussers.get(1).addPurchasedProduct(bibliographicproducts.get(1));
    }

}


    public String addBibliographic(String name, int numPages, LocalDate publicationDate,
     String url, double price, String review, int genreOption) {
        Book newBook = new Book(name, numPages, publicationDate, url, price, review, genreOption);
        bibliographicproducts.add(newBook);
        return "Book added successfully.";
    }
    
    public String addBibliographic1( String name, int numPages, LocalDate publicationDate, String url,
    double price, String periodicity, int genreOption2) {
    Magazine newMagazine = new Magazine(name, numPages, publicationDate,url,price,periodicity,genreOption2);
    bibliographicproducts.add(newMagazine);
    return "Magazine added successfully.";
    }
   
       
   
    public String addUser(String name, String id, LocalDate vinculationDate) {
        User newUser = new Regular(name, id, vinculationDate);
        ussers.add(newUser);
        return "Regular User added successfully.";
    }

    public String addUser(String name, String id, LocalDate vinculationDate, String creditCard) {
        Premium newPremiumUser = new Premium(name, id, vinculationDate, creditCard);
        ussers.add(newPremiumUser);
        return "Premium User added successfully.";
    }

    public boolean validateUser(String id) {
    boolean validate = true;
    for (int i = 0; i < ussers.size(); i++) {
        User user = ussers.get(i);
        if (user.getId().equals(id)) {
            validate = false;
            break;
        }
    }
    return validate;
    }

    public String getNameCompany() {
    return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
    this.nameCompany = nameCompany;
    }

    public String showUssers() {
    String msg = "";
    for (int i = 0; i < ussers.size(); i++) {
        User user = ussers.get(i);
        if (user != null) {
            msg += user.toString() + "\n";
        }
    }
    return msg;
    }
    public String showBibliographics() {
    String msg = "";
    for (int i = 0; i < bibliographicproducts.size(); i++) {
        Bibliographicproduct bibliographicproduct = bibliographicproducts.get(i);
        if (bibliographicproduct != null) {
            msg += bibliographicproduct.toString() + "\n";
        }
    }
    return msg;
}
public String showBibliographicsBook() {
    String msg = "";
    for (int i = 0; i < bibliographicproducts.size(); i++) {
        Bibliographicproduct bibliographicproduct = bibliographicproducts.get(i);
        if (bibliographicproduct instanceof Book) {
            msg += bibliographicproduct.toString() + "\n";
        }
    }
    return msg;
}
public String showBibliographicsMagazine() {
    String msg = "";
    for (int i = 0; i < bibliographicproducts.size(); i++) {
        Bibliographicproduct bibliographicproduct = bibliographicproducts.get(i);
        if (bibliographicproduct instanceof Magazine) {
            msg += bibliographicproduct.toString() + "\n";
        }
    }
    return msg;
}

	public String buyBibliographic(User user, Bibliographicproduct bibliographicproduct) {
	    if (ussers.contains(user) && bibliographicproducts.contains(bibliographicproduct)) {
	        user.addPurchasedProduct(bibliographicproduct);

            Sale sale=new Sale(bibliographicproduct, user);


            
	        return sale.generarFactura();
	    } else {
	        return "Usuario o producto no encontrado.";
	    }
	}

    public String buyProduct(String nameUser, String nameProduct) {
    	
    	Bibliographicproduct product = this.getBibliographicProductByName(nameProduct);
    	User user = this.getUserByName(nameUser);

        
    	
    	return this.buyBibliographic(user, product);
    }

	public Bibliographicproduct getBibliographicProductByName(String name) {
	    for (Bibliographicproduct product : bibliographicproducts) {
	        if (product.getName().equalsIgnoreCase(name)) {
	            return product;
	        }
	    }
	    return null;  
	}
    public Bibliographicproduct getBibliographicProductById(String id) {
	    for (Bibliographicproduct product : bibliographicproducts) {
	        if (product.getName().equalsIgnoreCase(id)) {
	            return product;
	        }
	    }
	    return null;  
	}
	public User getUserById(String id) {
	    for (User user : ussers) {
	        if (user.getId().equals(id)) {
	            return user;
	        }
	    }
	    return null; 
	}
	
	public User getUserByName(String name) {
		
		for (User user : ussers) {
	        if (user.getName().equals(name)) {
	            return user;
	        }
	    }
		return null;
	}
    public String[][] getUserLibraryMatriz(String userName) {
        User user = getUserByName(userName);
    
        if (user != null) {
            ArrayList<Bibliographicproduct> purchasedProducts = user.getPurchasedProducts();
            String[][] library = new String[ROWS][COLUMNS];
    
            int row = 0;
            int column = 0;
    
            for (Bibliographicproduct product : purchasedProducts) {
                library[row][column] = product.getId();
                column++;
                if (column == COLUMNS) {
                    column = 0;
                    row++;
                    if (row == ROWS) {
                        break;
                    }
                }
            }
    
            return library;
        } else {
            return null;
        }
    }
    

    public String deleteProductByName(String nombre) {
    	
        Bibliographicproduct productToDelete = getBibliographicProductByName(nombre);
        bibliographicproducts.remove(productToDelete);
        return "Product has been deleted successfully.";
    }
    

    public void modifyProduct(String name, double newPrice) {
    	Bibliographicproduct product = this.getBibliographicProductByName(name);
    	product.setPrice(newPrice);
    }
    public boolean validateProductByName(String name) {
	    for (Bibliographicproduct product : bibliographicproducts) {
	        if (product.getName().equalsIgnoreCase(name)) {
	            return true;
	        }
	    }
	    return false; 
	}

public boolean validateUserByName(String name) {
    for (User user : ussers) {
        if (user.getName().equalsIgnoreCase(name)) {
            return true;
        }
    }
    return false; 
}
public String showUserLibrary(String name) {
    User user = this.getUserByName(name);
    
   return user.showLibrary();
}
public Bibliographicproduct getLibraryProduct(String name, int fila, int columna) {
    User user = this.getUserByName(name);
    return user.getLibraryProduct(fila, columna);
}
public String informSalesByGenreBook() {
    int booksSoldCsi = 0;
    int booksSoldFantasy = 0;
    int booksSoldHistoric = 0;
    double salesCsi = 0.0;
    double salesFantasy = 0.0;
    double salesHistoric = 0.0;
    
    for (User user : ussers) {
        ArrayList<Bibliographicproduct> purchasedProducts = user.getPurchasedProducts();
        
        for (Bibliographicproduct product : purchasedProducts) {
            if (product instanceof Book) {
                Book book = (Book) product;
                GenreType genre = book.getGenre();
                
                if (genre == GenreType.Csi) {
                    booksSoldCsi++;
                    salesCsi += book.getPrice();
                } else if (genre == GenreType.Fantasy) {
                    booksSoldFantasy++;
                    salesFantasy += book.getPrice();
                } else if (genre == GenreType.Historic) {
                    booksSoldHistoric++;
                    salesHistoric += book.getPrice();
                }
            }
        }
    }
    
    String result = "Genre Csi - number books purchased: " + booksSoldCsi + " - total value paid: $" + salesCsi + "\n";
    result += "Genre Fantasy - number books purchased: " + booksSoldFantasy + " - total value paid: $" + salesFantasy + "\n";
    result += "Genre Historic - number books purchased: " + booksSoldHistoric + " -total value paid: $" + salesHistoric;
    
    return result;
}
public String informSuscriptionsByGenreMagazine() {
    int magazinesSusVarieties = 0;
    int magazinesSusDesign = 0;
    int magazinesSusdScie = 0;
    double susVarieties = 0.0;
    double susDesign = 0.0;
    double susScientific = 0.0;
    
    for (User user : ussers) {
        ArrayList<Bibliographicproduct> purchasedProducts = user.getPurchasedProducts();
        
        for (Bibliographicproduct product : purchasedProducts) {
            if (product instanceof Magazine) {
                Magazine magazine = (Magazine) product;
                GenreType2 genre = magazine.getGenreMagazine();
                
                if (genre == GenreType2.Varieties) {
                    magazinesSusVarieties++;
                    susVarieties += magazine.getPrice();
                } else if (genre == GenreType2.Design) {
                    magazinesSusDesign++;
                    susDesign += magazine.getPrice();
                } else if (genre == GenreType2.Scientific) {
                    magazinesSusdScie++;
                    susScientific += magazine.getPrice();
                }
            }
        }
    }
    
    
    String result = "Genre Varieties - number of Suscriptions: " + magazinesSusVarieties + " - total value paid: $" + susVarieties + "\n";
   
    result += "Genre Design - number of Suscriptions: " + magazinesSusDesign + " - total value paid: $" + susDesign + "\n";
    result += "Genre Scientific - number of Suscriptions: " + magazinesSusdScie + " - total value paid: $" + susScientific;
    
    return result;
}
public String informAcumPages() {
    int totalMagazinePages = 0;
    int totalBookPages = 0;

    for (User user : ussers) {
        ArrayList<ReadingSession> readingSessions = user.getReadingSessions();

        for (ReadingSession reading : readingSessions) {
            getBibliographicProductByName(reading.getBookName());
            Bibliographicproduct product = getBibliographicProductByName(reading.getBookName());

            if (product instanceof Magazine) {
                totalMagazinePages += reading.getCurrentPage();
            } else if (product instanceof Book) {
                totalBookPages += reading.getCurrentPage();
            }
        }
    }

    String result = "Accumulated pages read:\n";
    result += "Total magazine pages: " + totalMagazinePages + " pages\n";
    result += "Total book pages: " + totalBookPages + " pages\n";

    return result;
}
public String readingSession(String name, int fila, int columna) {
	
	User user = getUserByName(name);
	Bibliographicproduct libraryProduct = getLibraryProduct(name, fila, columna);
	
	return user.showReadingSession(libraryProduct.getName());
	
}

public void nextPageReadingSession(String name,  int fila, int columna) {
	User user = getUserByName(name);
	Bibliographicproduct libraryProduct = getLibraryProduct(name, fila, columna);
	
	user.getReadingSessionByName(libraryProduct.getName()).nextPage();
}

public void previusPageReadingSession(String name,  int fila, int columna) {
	User user = getUserByName(name);
	Bibliographicproduct libraryProduct = getLibraryProduct(name, fila, columna);
	
	user.getReadingSessionByName(libraryProduct.getName()).previousPage();
}
public void matrixNextPage(String name) {
    User user = this.getUserByName(name);
    user.nextMatrixPage();
}
public void matrixPreviousPage(String name) {

    User user = this.getUserByName(name);
    user.previousMatrixPage();

}
    public void reportMostGenderRead() {

        ArrayList<Bibliographicproduct> bookList = new ArrayList<>();
        ArrayList<Bibliographicproduct> magazineList = new ArrayList<>();

        ussers.forEach(null);

    }
}



