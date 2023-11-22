package restobar.Mappers;

import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOStock;
import restobar.Models.Product;
import restobar.Models.Stock;

public class MapperStock implements MapperInterface<DTOStock,Stock>
{

    @Override
    public Stock convertDtoToObj(DTOStock dto) {
        Stock o=new Stock();
        Product c=new Product();
        c.setId(dto.getIdProduct());
        o.setProduct(c);
        o.setTotal(dto.getTotal());
        return o;
    }

    @Override
    public DTOStock convertObjToDto(Stock o) {
        DTOStock dto=new DTOStock();
        dto.setIdProduct(o.getProduct().getId());
        dto.setTotal(o.getTotal());
        return dto;
    }

    @Override
    public List<Stock> convertListDtoToListObj(List<DTOStock> listDTO) {
        List<Stock> listStock=new ArrayList();
        for(int i=0;i<listDTO.size();i++)
        {
            listStock.add(convertDtoToObj(listDTO.get(i)));
        }
        return listStock;
    }
    
}
