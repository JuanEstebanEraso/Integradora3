package model;

import java.time.LocalDate;


public abstract class Bibliographicproduct {

    private String id;
    private String name;
    private int numPages;
    private LocalDate publicationDate;
    private String url;
    private double price;
    private int acumPagesRead=1;
    

       
        public Bibliographicproduct(String name, int numPages, LocalDate publicationDate,
         String url, double price) {
        	this.id= generateId();
            this.name = name;
            this.numPages = numPages;
            this.publicationDate = publicationDate;
            this.url = url;
            this.price = price;

        }
        public String getId() {
            return id;
        }
        
        public abstract String generateId();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public int getNumPages() {
            return numPages;
        }

        public LocalDate getPublicationDate() {
            return publicationDate;
        }

        public void setPublicationDate(LocalDate publicationDate) {
            this.publicationDate = publicationDate;
        }
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
        public int getAcumPagesRead() {
            return acumPagesRead;
        }
       
    public String toString(){
        return "Name: "+name+" id: "+ id  + " publication date: "+publicationDate+" price: "+price+"";
    }
		
 
}
    
    

