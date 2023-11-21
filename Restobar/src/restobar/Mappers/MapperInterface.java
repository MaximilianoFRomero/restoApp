package restobar.Mappers;

import java.util.List;

public interface MapperInterface<DTO,CLASS>
{
    public CLASS convertDtoToObj(DTO dto);
    public DTO convertObjToDto(CLASS o);
    public List<CLASS> convertListDtoToListObj(List<DTO> listDTO);
}
