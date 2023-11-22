package restobar.DTOs;

public class DTOTable
{
    private int id;
    private String name;
    private int idOrder;
    //Constructors
    public DTOTable(){}
    public DTOTable(int id,String name,int idOrder)
    {
        this.id=0;
        this.name="";
        this.idOrder=0;
    }
    //Getters and setters
    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public int getIdOrder(){return this.idOrder;}
    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setIdOrder(int idOrder){this.idOrder=idOrder;}
}
