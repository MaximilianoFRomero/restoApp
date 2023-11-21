package restobar.Mappers;

import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOCategory;
import restobar.Models.Category;

public class MapperCategory implements MapperInterface<DTOCategory,Category>
{
    public MapperCategory()
    {
    }

    @Override
    public Category convertDtoToObj(DTOCategory dto) {
        Category o=new Category();
        o.setId(dto.getId());
        o.setName(dto.getName());
        return o;
    }

    @Override
    public DTOCategory convertObjToDto(Category o) {
        DTOCategory dto=new DTOCategory();
        dto.setId(o.getId());
        dto.setName(o.getName());
        return dto;
    }

    @Override
    public List<Category> convertListDtoToListObj(List<DTOCategory> listDTO) {
        List<Category> listCategory=new ArrayList();
        for(int i=0;i<listDTO.size();i++)
        {
            listCategory.add(convertDtoToObj(listDTO.get(i)));
        }
        return listCategory;
    }

}
