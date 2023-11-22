package restobar.DTOs;

public class DTOStock
{
    private int idProduct;
    private int total;
    //Constructors
    public DTOStock(){}
    public DTOStock(int idProduct,int total)
    {
        this.idProduct=idProduct;
        this.total=total;
    }
    //Getters and setters
    public int getIdProduct(){return this.idProduct;}
    public int getTotal(){return this.total;}
    public void setIdProduct(int idProduct){this.idProduct=idProduct;}
    public void setTotal(int total){this.total=total;}
}
