package restobar.Controllers;

import java.util.ArrayList;
import java.util.List;
import restobar.Models.Category;

public class CategoryController
{
    private List<Category> categories;
    //Constructors
    public CategoryController()
    {
        this.categories=new ArrayList();
    }
    //Functions
    public void addCategory(int idCategory,String name)
    {
        this.categories.add(new Category(idCategory,name));
    }
    public void removeCategory(int index)
    {
        this.categories.remove(index);
    }
    public Category getCategory(int index)
    {
        return this.categories.get(index);
    }
}
