package restobar.Mappers;

import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOWaiter;
import restobar.Models.Waiter;

public class MapperWaiter implements MapperInterface<DTOWaiter,Waiter>
{
    public MapperWaiter()
    {
    }
    @Override
    public Waiter convertDtoToObj(DTOWaiter dto) {
        Waiter o=new Waiter();
        o.setId(dto.getId());
        o.setName(dto.getName());
        o.setLastName(dto.getLastName());
        return o;
    }

    @Override
    public DTOWaiter convertObjToDto(Waiter o) {
        DTOWaiter dto=new DTOWaiter();
        dto.setId(o.getId());
        dto.setName(o.getName());
        dto.setLastName(o.getLastName());
        return dto;
    }

    @Override
    public List<Waiter> convertListDtoToListObj(List<DTOWaiter> listDTO) {
        List<Waiter> listWaiter=new ArrayList();
        for(int i=0;i<listDTO.size();i++)
        {
            listWaiter.add(convertDtoToObj(listDTO.get(i)));
        }
        return listWaiter;
    }
}

