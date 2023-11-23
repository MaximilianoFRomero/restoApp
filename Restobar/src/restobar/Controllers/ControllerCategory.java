package restobar.Controllers;

import java.util.ArrayList;
import java.util.List;
import restobar.Mappers.MapperCategory;
import restobar.Models.Category;
import restobar.Persistence.DAOCategorySQL;
import restobar.Persistence.DAOException;

public class ControllerCategory
{
    private DAOCategorySQL dao;
    private MapperCategory mapper;
    //Constructors
    public ControllerCategory()
    {
        this.dao=new DAOCategorySQL();
        this.mapper=new MapperCategory();
    }
    //Functions
    public void addCategory(String name) throws DAOException
    {
        Category c=new Category();
        c.setName(name);
        this.dao.save(mapper.convertObjToDto(c));
    }
    public void modifyCategory(int id,String name) throws DAOException
    {
        if(id!=1)
        {
            Category c=new Category(id,name);
            this.dao.update(mapper.convertObjToDto(c));
        }else
            throw new DAOException("Not possible modify this category.");
    }
    public void removeCategoryById(int id) throws DAOException
    {
        if(id!=1)
        {
            Category c=new Category(id,"NONE");
            this.dao.delete(mapper.convertObjToDto(c));
        }else
            throw new DAOException("Not possible remove this category.");
    }
    public Category getCategoryById(int id) throws DAOException
    {
        return mapper.convertDtoToObj(this.dao.byId(id));
    }
    public List<Category> listAll() throws DAOException
    {
        return mapper.convertListDtoToListObj(dao.listAll());
    }
}
