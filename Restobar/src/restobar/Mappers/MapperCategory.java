package restobar.Mappers;

import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOCategory;
import restobar.Models.Category;

public class MapperCategory
{
    public MapperCategory()
    {
    }
    public Category convertDTOCategoryToCategory(DTOCategory dto)
    {
        Category c=new Category();
        c.setIdCategory(dto.getId());
        c.setName(dto.getName());
        return c;
    }
    public DTOCategory convertCategoryToDTOCategory(Category c)
    {
        DTOCategory dto=new DTOCategory();
        dto.setId(c.getIdCategory());
        dto.setName(c.getName());
        return dto;
    }
    public List<Category> convertDTOCategoriesToCategories(List<DTOCategory> listDTO)
    {
        List<Category> listCategory=new ArrayList();
        for(int i=0;i<listDTO.size();i++)
        {
            listCategory.add(convertDTOCategoryToCategory(listDTO.get(i)));
        }
        return listCategory;
    }
}
