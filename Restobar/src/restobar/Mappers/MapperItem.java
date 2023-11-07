package restobar.Mappers;

import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOItem;
import restobar.Models.Item;

public class MapperItem
{
    public MapperItem()
    {
    }
    public Item convertDTOItemToItem(DTOItem dto)
    {
        Item i=new Item();
        i.setIdProduct(dto.getIdProduct());
        i.setIdOrder(dto.getIdOrder());
        i.setTotalProduct(dto.getTotalProduct());
        return i;
    }
    public DTOItem convertItemToDTOItem(Item i)
    {
        DTOItem dto=new DTOItem();
        dto.setIdProduct(i.getIdProduct());
        dto.setIdOrder(i.getIdOrder());
        dto.setTotalProduct(i.getTotalProduct());
        return dto;
    }
    public List<Item> convertDTOCategoriesToCategories(List<DTOItem> listDTO)
    {
        List<Item> listItem=new ArrayList();
        for(int i=0;i<listDTO.size();i++)
        {
            listItem.add(convertDTOItemToItem(listDTO.get(i)));
        }
        return listItem;
    }
}
