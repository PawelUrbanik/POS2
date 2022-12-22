package pl.pawel.discriminant.service;


import pl.pawel.discriminant.model.DiscirminantDto;

import java.util.List;

public interface DiscriminantService {

    List<DiscirminantDto> getAllDiscriminants();

    DiscirminantDto updateDiscriminant(DiscirminantDto dtoToUpdate);

    DiscirminantDto createNewDiscriminant(DiscirminantDto dtoToSave);

    void deleteById(Long id);

}
