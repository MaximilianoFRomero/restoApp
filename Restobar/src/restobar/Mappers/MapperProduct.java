package restobar.Mappers;

import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOProduct;
import restobar.Models.Category;
import restobar.Models.Price;
import restobar.Models.Product;

public class MapperProduct implements MapperInterface<DTOProduct,Product>
{
    public MapperProduct()
    {
    }

    @Override
    public Product convertDtoToObj(DTOProduct dto) {
        Product o=new Product();
        o.setId(dto.getId());
        o.setName(dto.getName());
        o.setDescription(dto.getDescription());
        o.setPrice(new Price(dto.getPrice()));
        Category c=new Category(dto.getIdCategory(),"");
        o.setCategory(c);
        return o;
    }

    @Override
    public DTOProduct convertObjToDto(Product o) {
        DTOProduct dto=new DTOProduct();
        dto.setId(o.getId());
        dto.setName(o.getName());
        dto.setDescription(o.getDescription());
        dto.setPrice(o.getPrice().getValue());
        dto.setIdCategory(o.getCategory().getId());
        return dto;
    }

    @Override
    public List<Product> convertListDtoToListObj(List<DTOProduct> listDTO) {
        List<Product> listProduct=new ArrayList();
        for(int i=0;i<listDTO.size();i++)
        {
            listProduct.add(convertDtoToObj(listDTO.get(i)));
        }
        return listProduct;
    }
}
