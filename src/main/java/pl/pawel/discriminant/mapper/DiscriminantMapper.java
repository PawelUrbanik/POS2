package pl.pawel.discriminant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pl.pawel.discriminant.model.DiscirminantDto;
import pl.pawel.discriminant.model.Discriminant;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiscriminantMapper {

    DiscirminantDto disciminantToDiscriminantDto(Discriminant discriminant);
}
