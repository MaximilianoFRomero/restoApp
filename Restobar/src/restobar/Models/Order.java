package restobar.Models;

//import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Order//Pedido
{
    /*
    private LocalDateTime dateOpen;
    private LocalDateTime dateClose;
    */
    private List<Product> products;
    //Constructors
    public Order()
    {
        this.products=new ArrayList();
    }
    public Order(List<Product> products)
    {
        
    }
    //Functions
    public void addProduct(Product product)
    {
        this.products.add(product);
    }
    public void removeProduct(int index)
    {
        this.products.remove(index);
    }
    public Product getProduct(int index)
    {
        return this.products.get(index);
    }
}

