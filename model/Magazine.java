package model;
import java.time.LocalDate;
import java.util.Random;

public class Magazine extends Bibliographicproduct {

    private String periodicity;
    private int numActiveSuscriptions;
    private GenreType2 genreMagazine;  
    protected String id;
    private int numPagesReadMagazine;


    public Magazine( String name, int numPages, LocalDate publicationDate,
    String url, double price,String periodicity,int genreOption2){
        super(name,numPages,publicationDate,url,price);
        this.id=generateId();
        this.periodicity=periodicity;
        this.numActiveSuscriptions=0;
        this.genreMagazine = getGenreType2(genreOption2);
        this.numPagesReadMagazine=0;

    }
    private GenreType2 getGenreType2(int genreOption2) {
        switch (genreOption2) {
            case 1:
                return GenreType2.Varieties;
            case 2:
                return GenreType2.Design;
            case 3:
                return GenreType2.Scientific;
            default:
                throw new IllegalArgumentException("Invalid genre option: " + genreOption2);
        }
    }

@Override
public String generateId() {
    Random random = new Random();
    String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    char[] idChars = new char[3];
    for (int i = 0; i < 3; i++) {
        idChars[i] = alphanumericCharacters.charAt(random.nextInt(alphanumericCharacters.length()));
    }
    return new String(idChars);
}
public GenreType2 getGenreMagazine() {
    return genreMagazine;
}

public void setGenreMagazine(GenreType2 genreMagazine) {
    this.genreMagazine = genreMagazine;
}


        public String getPeriodicity() {
            return periodicity;
        }
        public void setPeriodicity(String periodicity) {
            this.periodicity = periodicity;
        }
        public int getNumActiveSuscriptions() {
            return numActiveSuscriptions;
        }
        public void setNumActiveSuscriptions(int numActiveSuscriptions) {
            this.numActiveSuscriptions = numActiveSuscriptions;
        }

     
        public int getNumPagesReadMagazine() {
            return numPagesReadMagazine;
        }
    
        public void setNumPagesReadMagazine(int numPagesReadMagazine) {
            this.numPagesReadMagazine = numPagesReadMagazine;
        }
    
    }
    

