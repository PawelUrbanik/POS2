package pl.pawel.platform.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import pl.pawel.platform.model.Platform;
import pl.pawel.platform.model.PlatformSelectOptionDto;
import pl.pawel.platform.model.PlatformTabTableRowDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlatformMapper {

    PlatformSelectOptionDto entityToDto(Platform platform);

    PlatformTabTableRowDto entityToTableRowDto(Platform platform);
}
