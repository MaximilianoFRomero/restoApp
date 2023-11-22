package restobar.Mappers;

import java.util.ArrayList;
import java.util.List;
import restobar.DTOs.DTOTable;
import restobar.Models.Order;
import restobar.Models.Table;

public class MapperTable implements MapperInterface<DTOTable,Table>
{

    @Override
    public Table convertDtoToObj(DTOTable dto) {
        Table o=new Table();
        o.setId(dto.getId());
        o.setName(dto.getName());
        Order c=new Order();
        c.setId(dto.getIdOrder());
        o.setOrder(c);
        return o;
    }

    @Override
    public DTOTable convertObjToDto(Table o) {
        DTOTable dto=new DTOTable();
        dto.setId(o.getId());
        dto.setName(o.getName());
        dto.setIdOrder(o.getOrder().getId());
        return dto;
    }

    @Override
    public List<Table> convertListDtoToListObj(List<DTOTable> listDTO) {
        List<Table> listTable=new ArrayList();
        for(int i=0;i<listDTO.size();i++)
        {
            listTable.add(convertDtoToObj(listDTO.get(i)));
        }
        return listTable;
    }
    
}
