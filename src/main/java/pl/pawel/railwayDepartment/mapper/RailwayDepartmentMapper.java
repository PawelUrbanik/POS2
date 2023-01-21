package pl.pawel.railwayDepartment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import pl.pawel.railwayDepartment.model.RailwayDepartment;
import pl.pawel.railwayDepartment.model.RailwayDepartmentDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RailwayDepartmentMapper {

    RailwayDepartmentDto railwayDepartmentToDto(RailwayDepartment department);
    RailwayDepartment dtoToRailwayDepartment(RailwayDepartmentDto dto);
}
