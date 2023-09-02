package restobar.Models;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Order//Pedido
{
    private int amountPayable;//Monto a cobrar
    private int amountPaid;//Monto pagado
    private Date dateOpen;
    private Date dateClose;
    private List<Product> products;
    //Constructors
    public Order()
    {
        this.products=new ArrayList();
        this.amountPayable=0;
        this.amountPaid=0;
        this.dateOpen=new Date();
    }
    public Order(List<Product> products)
    {
        this.products=products;
    }
    //Getters and setters
    public int getAmountPayable(){return this.amountPayable;}
    public int getAmountPaid(){return this.amountPaid;}
    public Date getDateOpen(){return this.dateOpen;}
    public Date getDateClose(){return this.dateClose;}
    public void setDateOpen(Date dateOpen){this.dateOpen=dateOpen;}
    public void setDateClose(Date dateClose){this.dateClose=dateClose;}
    public void setAmountPayable(int amountPayable){this.amountPayable=amountPayable;}
    public void setAmountPaid(int amountPaid){this.amountPaid=amountPaid;}
    //Functions
    @Override
    public String toString()
    {
        String s="Order{\n";
        s+="amount_payable: "+amountPayable+",\n";
        s+="amount_paid: "+amountPaid+",\n";
        s+="date_open: "+dateOpen+",\n";
        s+="date_close: "+dateClose+",\n";
        s+="products: [\n";
        for(int i=0;i<this.products.size();i++)
        {
            s+="\t{name: "+products.get(i).getName()+",";
            s+="description: "+products.get(i).getDescription()+",";
            s+="price: "+products.get(i).getPrice()+",";
            s+="elaborated: "+products.get(i).getElaborated()+",";
            s+="category: "+products.get(i).getCategory()+"}";
            if(i+1<this.products.size())
                s+=",";
            s+="\n";
        }
        s+="]\n";
        s+="}";
        return s;
    }
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

