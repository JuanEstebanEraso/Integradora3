package model;

public class ReadingSession {

	private String productName;
	private int totalPages;
	private int currentPage = 1;

	public ReadingSession(String name, int pages) {
		this.productName = name;
		this.totalPages = pages;
	}
	
	public String getBookName() {
		return productName;
	}
	
	public int getCurrentPage() {
		return this.currentPage;
	}
	
	public String nextPage() {
		 if (this.currentPage < this.totalPages) {
			this.currentPage++;
			return "Page changed!!!";
		}else {
			return "Your on the laste page!!";
		}
	}
	
	public String previousPage() {
		if (this.currentPage > 1) {
			this.currentPage--;
			return "Page changed!!!";
		}else {
			return "Your on the first page!!";
		}
	}
	
	@Override
	public String toString() {
		return "Sesion de lectura en progreso:\n"
				+ "Leyendo: " + this.productName + "\n"
				+ "Leyenco pagina " + this.currentPage + " de " + this.totalPages + "\n\n";
	}
	
}
