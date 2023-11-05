package restobar.Mappers;

import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOWaiter;
import restobar.Models.Waiter;

public class MapperWaiter
{
    public MapperWaiter()
    {
    }
    public Waiter convertDTOWaiterToWaiter(DTOWaiter dto)
    {
        Waiter w=new Waiter();
        w.setId(dto.getId());
        w.setName(dto.getName());
        w.setLastName(dto.getLastName());
        return w;
    }
    public DTOWaiter convertWaiterToDTOWaiter(Waiter w)
    {
        DTOWaiter dto=new DTOWaiter();
        dto.setId(w.getId());
        dto.setName(w.getName());
        dto.setLastName(w.getLastName());
        return dto;
    }
    public List<Waiter> convertDTOWaitersToWaiters(List<DTOWaiter> listDTO)
    {
        List<Waiter> listCategory=new ArrayList();
        for(int i=0;i<listDTO.size();i++)
        {
            listCategory.add(convertDTOWaiterToWaiter(listDTO.get(i)));
        }
        return listCategory;
    }
}

