package model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public abstract class User {
    private String name;
    private String id;
    private LocalDate vinculationDate;
    protected ArrayList<Bibliographicproduct> purchasedProducts;
    private ArrayList<ReadingSession> readingSessions;
    private static final int ROWS = 5;
    private static final int COLUMNS= 5;
    private Bibliographicproduct[][] library;
    private ArrayList<Bibliographicproduct[][]>array= new ArrayList<>();

    public User(String name, String id, LocalDate vinculationDate) {
        this.name = name;
        this.id = id;
        this.vinculationDate = vinculationDate;
        purchasedProducts = new ArrayList<>();
        readingSessions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<ReadingSession> getReadingSessions() {
		return readingSessions;
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getVinculationDate() {
        return vinculationDate;
    }

    public void setVinculationDate(LocalDate vinculationDate) {
        this.vinculationDate = vinculationDate;
    }

    public void addPurchasedProduct(Bibliographicproduct product) {
        purchasedProducts.add(product);

        this.readingSessions.add(new ReadingSession(product.getName(), product.getNumPages()));
    }

    public ArrayList<Bibliographicproduct> getPurchasedProducts() {
        return purchasedProducts;
    }
    
    public abstract String showReadingSession(String name);
    
    public ReadingSession getReadingSessionByName(String name) {
    	
    	for (ReadingSession sesions : readingSessions) {
            if (sesions.getBookName().equalsIgnoreCase(name)) {
                return sesions;
            }
        
    	}return null;
    }
    
    public Bibliographicproduct getPurchasedProduct(String name) {
    	
    	for (Bibliographicproduct product : purchasedProducts) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        
    	}return null;
    }
    
    public Bibliographicproduct[][] LoadLibrary(int iterator) {
      Collections.sort(purchasedProducts, Comparator.comparing(Bibliographicproduct::getPublicationDate).reversed());
      int condition = iterator;
      library=new Bibliographicproduct[ROWS][COLUMNS]; 
      for (int i = 0; i < User.ROWS; i++) {
          for (int j = 0; j < User.COLUMNS; j++) {
              if (condition < purchasedProducts.size()) {
                  Bibliographicproduct product = purchasedProducts.get(condition);
                  library[i][j] = product;
                  condition++;
                 
              }
          }
      }
     return  library;
  }
    
    private void loadArrayLibrary() {
    	int times = purchasedProducts.size() - 25;
    	int ite = 0;
    	
    	do {
			array.add(this.LoadLibrary(ite));
			ite += 25;
			times -= 25;
		}
	    while (times > 0);
    }
    
    public String showLibrary(int iterator) {
    	this.loadArrayLibrary();
      Bibliographicproduct[][] ar = this.array.get(iterator);
      
      if (iterator >= 0 && iterator < array.size()) {
    	  StringBuilder ret = new StringBuilder("     0   |   1   |   2   |   3   |   4\n");
    	  
          for (int i = 0; i < User.ROWS; i++) {
              ret.append(i + " | ");
              for (int j = 0; j < User.COLUMNS; j++) {
                  Bibliographicproduct product = ar[i][j];
                  if (product != null) {
                      ret.append(product.getId() + "  | ");
                  } else {
                      ret.append("      | ");
                  }
              }
              ret.append("\n");
          }
          ret.append("\n");
          return ret.toString();
      }
      return "error";
      
	}
      
      
    
    public Bibliographicproduct getLibraryProduct(int x, int y) {
 		return library[x][y];
 	}

    @Override
    public String toString() {
        return "Name: " + name + " id: " + id + " vinculation date: " + vinculationDate;
    }
}



