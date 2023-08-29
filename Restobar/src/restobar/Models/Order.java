package restobar.Models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private LocalDateTime dateOpen;
    private LocalDateTime dateClose;
    private List<Product> productList;
    public Order()
    {
        this.productList=new ArrayList();
    }
}
