package model;
import java.time.LocalDate;
import java.util.Random;


public class Book extends Bibliographicproduct {


    private String review;
    private GenreType genre;
    private int numCopiesSold;
    private int numPagesReadBook;
    protected String id;


    public Book(String name, int numPages, LocalDate publicationDate, String url, double price, 
    String review, int genreOption) {
        super(name, numPages, publicationDate, url, price);
        this.id = generateId();
        this.review = review;
        this.genre = getGenreType(genreOption);
        this.numCopiesSold = 0;
        this.numPagesReadBook = 0;
    }
    
    private GenreType getGenreType(int genreOption) {
        switch (genreOption) {
            case 1:
                return GenreType.Csi;
            case 2:
                return GenreType.Fantasy;
            case 3:
                return GenreType.Historic;
            default:
                throw new IllegalArgumentException("Invalid genre option: " + genreOption);
        }
    }
  

     @Override
    public String generateId() {
    Random random = new Random();
    String hexCharacters = "0123456789ABCDEF";
    char[] idChars = new char[3];
    for (int i = 0; i < 3; i++) {
        idChars[i] = hexCharacters.charAt(random.nextInt(hexCharacters.length()));
    }
    return new String(idChars);
    }


    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    public GenreType getGenre() {
        return genre;
    }
    public void setGenre(GenreType genre) {
        this.genre = genre;
    }
    public int getNumCopiesSold() {
        return numCopiesSold;
    }
    public void setNumCopiesSold(int numCopiesSold) {
        this.numCopiesSold = numCopiesSold;
    }
    public int getNumPagesReadBook() {
        return numPagesReadBook;
    }

    public void setNumPagesReadBook(int numPagesReadBook) {
        this.numPagesReadBook = numPagesReadBook;
    }

 

}
