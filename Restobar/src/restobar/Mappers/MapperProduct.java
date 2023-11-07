package restobar.Mappers;

import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOProduct;
import restobar.Models.Category;
import restobar.Models.Price;
import restobar.Models.Product;

public class MapperProduct
{
    public MapperProduct()
    {
    }
    public Product convertDTOProductToProduct(DTOProduct dto)
    {
        Product p=new Product();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setPrice(new Price(dto.getPrice()));
        p.setStock(dto.getStock());
        Category c=new Category();
        c.setId(dto.getIdCategory());
        p.setCategory(c);
        return p;
    }
    public DTOProduct convertProductToDTOProduct(Product p)
    {
        DTOProduct dto=new DTOProduct();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setDescription(p.getDescription());
        dto.setPrice(p.getPrice().getValue());
        dto.setStock(p.getStock());
        dto.setIdCategory(p.getCategory().getId());
        return dto;
    }
    public List<Product> convertDTOProductsToProducts(List<DTOProduct> listDTO)
    {
        List<Product> listProduct=new ArrayList();
        for(int i=0;i<listDTO.size();i++)
        {
            listProduct.add(convertDTOProductToProduct(listDTO.get(i)));
        }
        return listProduct;
    }
}
