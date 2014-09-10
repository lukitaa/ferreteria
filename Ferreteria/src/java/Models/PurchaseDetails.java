
package Models;

public class PurchaseDetails {
    
    private Product product; 
    private int cant;
    private int price;
    
    //Getters - setters
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product h) {
        this.product = h;
    }
    public int getCant() {
        return cant;
    }
    public void setCant(int cant) {
        this.cant = cant;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
