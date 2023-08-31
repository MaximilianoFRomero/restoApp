package restobar.Models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Order//Pedido
{
    private int amountPayable;//Monto a cobrar
    private int amountPaid;//Monto pagado
    private LocalDateTime dateOpen;
    private LocalDateTime dateClose;
    private List<Product> products;
    //Constructors
    public Order()
    {
        this.products=new ArrayList();
    }
    public Order(List<Product> products)
    {
        
    }
    //Getters and setters
    public int getAmountPayable(){return this.amountPayable;}
    public int getAmountPaid(){return this.amountPaid;}
    public LocalDateTime getDateOpen(){return this.dateOpen;}
    public LocalDateTime getDateClose(){return this.dateClose;}
    public void setDateOpen(LocalDateTime dateOpen){this.dateOpen=dateOpen;}
    public void setDateClose(LocalDateTime dateClose){this.dateOpen=dateClose;}
    public void setAmountPayable(int amountPayable){this.amountPayable=amountPayable;}
    public void setAmountPaid(int amountPaid){this.amountPaid=amountPaid;}
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

