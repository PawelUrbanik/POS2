package pl.pawel.operatingControlPoint.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;
import pl.pawel.operatingControlPoint.model.OperatingControlPointDto;
import pl.pawel.operatingControlPoint.model.OperatingControlPointRowDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OperatingControlPointMapper {

    OperatingControlPoint dtoToEntity(OperatingControlPointDto dto);

    OperatingControlPointDto entityToDto(OperatingControlPoint entity);

    @Mapping(target = "railwayDepartment", source = "entity.railwayDepartment.name")
    @Mapping(target = "discriminant", source = "entity.discriminant.shortcut")
    @Mapping(target = "numberOfPlatforms", source = "numberOfPlatforms")
    @Mapping(target = "numberOfLines", source = "numberOfLines")
    OperatingControlPointRowDto entityToRowDto(OperatingControlPoint entity, Integer numberOfPlatforms, Integer numberOfLines);
}
