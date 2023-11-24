package restobar.Mappers;

import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOItem;
import restobar.Models.Item;
import restobar.Models.Product;

public class MapperItem implements MapperInterface<DTOItem,Item>
{
    public MapperItem()
    {
    }

    @Override
    public Item convertDtoToObj(DTOItem dto) {
        Item o=new Item();
        Product p=new Product();
        p.setId(dto.getIdProduct());
        o.setProduct(p);
        o.setIdOrder(dto.getIdOrder());
        o.setTotalProduct(dto.getTotalProduct());
        o.setIndividualPrice(dto.getIndividualPrice());
        return o;
    }

    @Override
    public DTOItem convertObjToDto(Item o) {
        DTOItem dto=new DTOItem();
        dto.setIdProduct(o.getProduct().getId());
        dto.setIdOrder(o.getIdOrder());
        dto.setTotalProduct(o.getTotalProduct());
        dto.setIndividualPrice(o.getIndividualPrice());
        return dto;
    }

    @Override
    public List<Item> convertListDtoToListObj(List<DTOItem> listDTO) {
        List<Item> listItem=new ArrayList();
        for(int i=0;i<listDTO.size();i++)
        {
            listItem.add(convertDtoToObj(listDTO.get(i)));
        }
        return listItem;
    }
}
