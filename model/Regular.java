package model;

import java.time.LocalDate;



public class Regular extends User {
    private static final int MAX_BOOKS = 5;
    private static final int MAX_MAGAZINES = 2;

    private int  numBooksPurchased;
    private int numMagazinesSubscribed;
    
    public Regular(String name,String id,LocalDate vinculationDate){
        super(name, id,vinculationDate);
        this.numBooksPurchased=0;
        this.numMagazinesSubscribed=0;
    }
    public int getNumbookspurchased() {
        return numBooksPurchased;
    }
    public int getNumSubscribedMagazines() {
        return numMagazinesSubscribed;
    }
    @Override
    public void addPurchasedProduct(Bibliographicproduct product) {
        if (product instanceof Book) {
            if (numBooksPurchased < MAX_BOOKS) {
                purchasedProducts.add(product);
                this.getReadingSessions().add(new ReadingSession(product.getName(), product.getNumPages()));
                numBooksPurchased++;
                
            }
        } else if (product instanceof Magazine) {
            if (numMagazinesSubscribed < MAX_MAGAZINES) {
            	this.getReadingSessions().add(new ReadingSession(product.getName(), product.getNumPages()));
                purchasedProducts.add(product);
                numMagazinesSubscribed++;
                
            }
        }
        
    }
	@Override
	public String showReadingSession(String name) {
		
		ReadingSession readingSession = getReadingSessionByName(name);
		Bibliographicproduct purchasedProduct = getPurchasedProduct(name);
		String session = readingSession.toString();
		String add = this.add();
		
		if (purchasedProduct instanceof Book) {
			if (readingSession.getCurrentPage() == 1 || readingSession.getCurrentPage() % 20 == 0) {
				return add + session;
			}else {
				return session;
			}
			
		}
		
		if (purchasedProduct instanceof Magazine) {
			
			if (readingSession.getCurrentPage() == 1 || readingSession.getCurrentPage() % 5 == 0) {
				return add + session;
			}else {
				return session;
			}
			
		}
		
		return "";
	}
    
    public String add() {
    	 int random = generateRandomNum();
         
       String add;
      
       switch (random) {
           case 0:
               add = "¡Suscríbete al Combo Plus y llévate Disney+ y Star+ a un precio increíble!\n";
               break;
           case 1:
               add = "Ahora tus mascotas tienen una app favorita: Laika. Los mejores productos para tu peludito.\n";
               break;
           case 2:
               add = "¡Estamos de aniversario! Visita tu Éxito más cercano y sorpréndete con las mejores ofertas.\n";
               break;
           default:
               return "";
       }
      
       return add;
    }
    
    public int generateRandomNum(){
      int min=0;
      int max=2;
      int random =(int)(Math.random()*(max-min+1))+min; 
      return random;
  }
    
   
}