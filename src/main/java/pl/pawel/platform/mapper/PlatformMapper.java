package pl.pawel.platform.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pl.pawel.edge.model.Edge;
import pl.pawel.platform.model.Platform;
import pl.pawel.platform.model.PlatformDto;
import pl.pawel.platform.model.PlatformSelectOptionDto;
import pl.pawel.platform.model.PlatformTabTableRowDto;

import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlatformMapper {

    PlatformSelectOptionDto entityToDto(Platform platform);

    PlatformDto entityToPlatformDto(Platform platform);

    @Mapping(target = "numberOfEdges", expression = "java(countEdges(platform.getEdges()))")
    PlatformTabTableRowDto entityToTableRowDto(Platform platform);

    default Integer countEdges(Set<Edge> edges) {
        return edges == null ? 0 : edges.size();
    }
}
