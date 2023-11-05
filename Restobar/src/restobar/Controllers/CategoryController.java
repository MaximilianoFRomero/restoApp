package restobar.Controllers;

import java.util.ArrayList;
import java.util.List;
import restobar.Mappers.MapperCategory;
import restobar.Models.Category;
import restobar.Persistence.DAOCategorySQL;
import restobar.Persistence.DAOException;

public class CategoryController
{
    private DAOCategorySQL dao;
    private MapperCategory mapper;
    //Constructors
    public CategoryController()
    {
        this.dao=new DAOCategorySQL();
        this.mapper=new MapperCategory();
    }
    //Functions
    public void addCategory(String name) throws DAOException
    {
        Category c=new Category();
        c.setName(name);
        this.dao.save(mapper.convertCategoryToDTOCategory(c));
    }
    public void removeCategory(int index)
    {
    }
    public Category getCategoryById(long id) throws DAOException
    {
        return mapper.convertDTOCategoryToCategory(this.dao.byId(id));
    }
    public List<Category> listAll() throws DAOException
    {
        return mapper.convertDTOCategoriesToCategories(dao.listAll());
    }
}
