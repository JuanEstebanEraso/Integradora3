package ui;

import java.time.LocalDate;
import java.util.Scanner;
import model.Company;


public class Manager {
   
    
    private Company readX;


    public Manager() {
        this.readX = new Company("readX"); 
    }

    public static void main(String[] args) {
        Manager objManager = new Manager();
        objManager.menu();  
    }
    
    public void menu() {
        System.out.println("Welcome to ReadX");
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int option;
        while (!salir) {
            System.out.println("1. Administrator");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.println("Enter the option you want:");

            option = sn.nextInt();
            sn.nextLine();
            switch (option) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    userMenu();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Only enter numbers between 1 and 3");
            }
            System.out.println();
        }
    }
    
    public void adminMenu() {
        System.out.println("Administrator Menu");
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int option;
        while (!salir) {
            System.out.println("1. Register regular user");
            System.out.println("2. Register premium user");
            System.out.println("3. Show all users");
            System.out.println("4. Register book");
            System.out.println("5. Register magazine");
            System.out.println("6. Modify product ");
            System.out.println("7. Delete product ");
            System.out.println("8. Show Inform sales by genre of book");
            System.out.println("9. Show Inform suscriptions by genre of magazine");
            System.out.println("10. generate test cases");
            System.out.println("11. sale ");
            System.out.println("12. Show inform number of pages readed for each genre ");
            System.out.println("13. Exit");
            System.out.println("Enter the option you want:");

            option = sn.nextInt();
            sn.nextLine();
            switch (option) {
                case 1:
                    registerUser(option);
                    break;
                case 2:
                    registerUser(option);
                    break;
                case 3:
                    showUssers();
                    break;
                case 4:
                    registerBibliographicProduct(option);
                    break;
                case 5: 
                    registerBibliographicProduct(option);
                    break;
                case 6:
                    modifyProduct();
                    break;
                case 7:
                    deleteProduct();
                    break;
                case 8:
                informSalesByGenreBook();
                    break;
                    case 9:
                informSuscriptionsByGenreMagazine();
                break;
                case 10:
                generateTestCases();
                break;
                case 11:
                saleAutomatic();
                break;
                case 12:
                informAcumPages();;
                break;

                case 13:
                    salir = true;
                    break;
                default:
                    System.out.println("Only enter numbers between 1 and 13");
            }
            System.out.println();
        }
    }

    public void userMenu() {
        System.out.println("User Menu");
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int option;
        while (!salir) {
            System.out.println("1.View Books Catalogue");
            System.out.println("2.View Magazine Catalogue");
            System.out.println("3.buy a book or suscribe to a magazine");
            System.out.println("4.view library");
            System.out.println("7. Exit");
            System.out.println("Enter the option you want:");

            option = sn.nextInt();
            sn.nextLine();
            switch (option) {
                case 1:
                	showBibliographicsBook();
                    break;
                    case 2:
                	showBibliographicsMagazine();
                    break;
                case 3:
                	saleProduct();
                    break;
                case 4:
                    showLibrary();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Only enter numbers between 1 and 7");
            }
            System.out.println();
        }
    }

    
    private void saleProduct() {
		
        String userName;
        String productName;
       
        Scanner sn = new Scanner(System.in);
   
        System.out.println("Enter your name:");
        userName = sn.nextLine();
        
        System.out.println("Enter the name product:");
        productName = sn.nextLine();
        
        System.out.println(this.readX.buyProduct(userName, productName));
      }

		public void registerUser(int option) {
            String name;
            String id;
           
            Scanner sn = new Scanner(System.in);
            System.out.println("Enter the name:");
            name = sn.nextLine();
            System.out.println("Enter the id:");
            id = sn.nextLine();
            LocalDate vinculationDate = LocalDate.now();
            
            if (option==1){  
            if (readX.validateUser(id)) {
                System.out.println(readX.addUser(name,id,vinculationDate));
            } else {
                System.out.println("the user already exists");
            }
            
        
         }else if (option==2){
                String creditCard;
                System.out.println("Enter the credit card");
                creditCard=sn.nextLine();
                
                if (readX.validateUser(id)) {
                    System.out.println(readX.addUser(name,id,vinculationDate,creditCard));  
                } else {
                    System.out.println("the user already exists");
                }
 
        }
    }
    

    public void informSalesByGenreBook(){
        System.out.println(readX.informSalesByGenreBook());
        }
        public void generateTestCases(){
            readX.generateTestCases();
        }
        public void saleAutomatic(){
            readX.saleAutomatic();
        }
        public void informSuscriptionsByGenreMagazine(){
            System.out.println(readX.informSuscriptionsByGenreMagazine());
            }
            public void informAcumPages(){
                System.out.println(readX.informAcumPages());
                }
    public void showUssers(){
    System.out.println(readX.showUssers());
    }
    public void showBibliographicsBook(){
        System.out.println(readX.showBibliographicsBook());
        }
        public void showBibliographicsMagazine(){
            System.out.println(readX.showBibliographicsMagazine());
            }
    public void showBibliographics(){
    System.out.println(readX.showBibliographics());
    }
  

    public void deleteProduct(){
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter the name of the product you want to delete: ");
        String name = sn.nextLine();
        boolean ifExist = readX.validateProductByName(name);
        if (ifExist) {
            System.out.println(readX.deleteProductByName(name));
        } else {
            System.out.println("Product not found.");
        }
    }

    public void modifyProduct() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter the name of the product you want to modify: ");
        String name = sn.nextLine();
        boolean ifExist = readX.validateProductByName(name);
    
        if (ifExist) {
            System.out.println("Product found. Enter the new price: ");
            double newPrice = sn.nextDouble();
            this.readX.modifyProduct(name, newPrice);
            System.out.println("Product has been modified successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }
    public void registerBibliographicProduct(int option){
    	
	    String name;
	    int numPages;
	    String url;
	    double price;
	    
	    Scanner sn = new Scanner(System.in);
	    System.out.println("Enter the name:");
	    name = sn.nextLine();
	    System.out.println("Enter the number of pages:");
	    numPages = sn.nextInt();
	    sn.nextLine(); 
	    System.out.println("Enter the url:");
	    url = sn.nextLine();
	    System.out.println("Enter the price:");
	    price = sn.nextDouble();
	    if (option == 4){  
	        String review;   
	        System.out.println("Enter the review:");
	        review = sn.nextLine();
            sn.nextLine();
            System.out.print("Enter the publication year: ");
            int year = sn.nextInt();
            System.out.print("Enter the publication month: ");
            int month = sn.nextInt();
            System.out.print("Enter the publication day: ");
            int day = sn.nextInt();
            LocalDate publicationDate = LocalDate.of(year, month, day);
            System.out.println("Enter the genre:\n1. Sci\n2. Fantasy\n3. Historic");
            int genreOption = sn.nextInt();
	    
	        System.out.println(readX.addBibliographic(name, numPages, publicationDate, url, price, review, genreOption));
	    } else if (option == 5){
	        String periodicity;
	        System.out.println("Enter the periodicity:");
	        sn.nextLine(); 
	        periodicity = sn.nextLine();
            System.out.print("Enter the publication year: ");
            int year = sn.nextInt();
            System.out.print("Enter the publication month: ");
            int month = sn.nextInt();
            System.out.print("Enter the publication day: ");
            int day = sn.nextInt();
    
            LocalDate publicationDate = LocalDate.of(year, month, day);
        
            System.out.println("Enter the genre:\n1. Varieties\n2. Design\n3. Scientific");
            int genreOption2 = sn.nextInt();
           
 
	        System.out.println(readX.addBibliographic1(name, numPages, publicationDate, url, price, periodicity, genreOption2));
	    } else {
	        System.out.println("Invalid option.");
	    }
}
public void showLibrary() {
	boolean salir = false;
	Character opcion;
    Scanner sn = new Scanner(System.in);
    System.out.println("Enter your name:");
    String name = sn.nextLine();
    int page = 0;

    boolean ifUserExist = readX.validateUserByName(name);
    if (ifUserExist) {
    	
    	do {
    		System.out.println(this.readX.showUserLibrary(name, page));
    		System.out.println("Type C to access the reading session of a product\n"
    				+ "Enter A to go to the previous page\n"
    				+ "Type S to go to the next page\n"
    				+ " type E to exit");
    		
    		opcion = sn.next().charAt(0);
    		
    		switch (Character.toUpperCase(opcion)) {
    		
			case 'C':
				
				int fila, columna;
				Character opc;
				boolean out = false;
				
				System.out.println("Enter the coordinate x");
				fila = sn.nextInt();
				System.out.println("Enter the coordinate y");
				columna = sn.nextInt();
				
				
				
				do {
					
				System.out.println(this.readX.readingSession(name, fila, columna));
					
					System.out.println("Enter A to go to the previous page\n"
							+ "Enter S to go to the next page\n"
							+ "Type B to return to the Library");
					
					opc = sn.next().charAt(0);
					
					switch (Character.toUpperCase(opc)) {
					
					case 'A':
						this.readX.previusPageReadingSession(name, fila, columna);
						break;
						
					case 'S':
						this.readX.nextPageReadingSession(name, fila, columna);
						break;
					
					case 'B':
						out = true;
						break;

					default:
						break;
					}
				} while (!out);
				
				
				break;
				
			case 'A':
				page--;
				System.out.println(this.readX.showUserLibrary(name, page));
				
				break;
				
			case 'S':
				page++;
				System.out.println(this.readX.showUserLibrary(name, page));
				break;
			
			case 'E':
				salir = true;
				break;

			default:
				System.out.println("enter a valid option");
				break;
			}
    		
		} while (!salir);
    	
        }
    else {
        System.out.println("User not found.");
    }
}


}








