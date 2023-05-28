package model;
import java.time.LocalDate;
public class Sale {
    private LocalDate operationDate; 
    private User comprador;
    private Bibliographicproduct producto;

    public Sale(Bibliographicproduct producto, User usuario) {
        this.operationDate = LocalDate.now();
        this.comprador = usuario;
        this.producto = producto;
    }
    
    public String compraProducto() {
    	
    	try {
    		this.comprador.addPurchasedProduct(producto);
    	} catch (Exception e) {
			return "Ocurrio un error en la compra";
		}
    	
    	return this.generarFactura();
    }
    
    
    public String generarFactura() {
    	
    	return "==Factura==\n"
    			+ "Fecha: " + this.operationDate
    			+ "\nprecio: " + this.producto.getPrice();
    	
    }

}