package restobar.Mappers;

import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOOrder;
import restobar.Models.Order;
import restobar.Models.Waiter;

public class MapperOrder implements MapperInterface<DTOOrder,Order>
{
    public MapperOrder()
    {
    }
    
    @Override
    public Order convertDtoToObj(DTOOrder dto) {
        Order o=new Order();
        o.setId(dto.getId());
        o.setIdTable(dto.getIdTable());
        Waiter c=new Waiter();
        c.setId(dto.getIdWaiter());
        o.setWaiter(c);
        o.setCutlery(dto.getCutlery());
        o.setDateOpen(dto.getDateOpen());
        o.setDateClose(dto.getDateClose());
        o.setTotalPrice(dto.getTotalPrice());
        return o;
    }

    @Override
    public DTOOrder convertObjToDto(Order o) {
        DTOOrder dto=new DTOOrder();
        dto.setId(o.getId());
        dto.setIdTable(o.getIdTable());
        dto.setIdWaiter(o.getWaiter().getId());
        dto.setCutlery(o.getCutlery());
        dto.setDateOpen(o.getDateOpen());
        dto.setDateClose(o.getDateClose());
        dto.setTotalPrice(o.getTotalPrice());
        return dto;
    }

    @Override
    public List<Order> convertListDtoToListObj(List<DTOOrder> listDTO) {
        List<Order> listOrder=new ArrayList();
        for(int i=0;i<listDTO.size();i++)
        {
            listOrder.add(convertDtoToObj(listDTO.get(i)));
        }
        return listOrder;
    }
}
