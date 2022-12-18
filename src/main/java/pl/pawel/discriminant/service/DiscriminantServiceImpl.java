package pl.pawel.discriminant.service;

import org.springframework.stereotype.Service;
import pl.pawel.discriminant.mapper.DiscriminantMapper;
import pl.pawel.discriminant.model.DiscirminantDto;
import pl.pawel.discriminant.model.Discriminant;
import pl.pawel.discriminant.repository.DisciminantRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscriminantServiceImpl implements DiscriminantService{

    private final DisciminantRepository disciminantRepository;
    private final DiscriminantMapper discriminantMapper;

    public DiscriminantServiceImpl(DisciminantRepository disciminantRepository, DiscriminantMapper discriminantMapper) {
        this.disciminantRepository = disciminantRepository;
        this.discriminantMapper = discriminantMapper;
    }

    @Override
    public List<DiscirminantDto> getAllDiscriminants() {
        final List<Discriminant> discriminantList = disciminantRepository.findAll();
        List<DiscirminantDto> discirminantDtos = new ArrayList<>();
        discriminantList.forEach(discriminant -> discirminantDtos.add(discriminantMapper.disciminantToDiscriminantDto(discriminant)));
        return discirminantDtos;
    }

    @Override
    public DiscirminantDto updateDiscriminant(DiscirminantDto dtoToUpdate) {

        final Discriminant discriminantToUpdate = discriminantMapper.discriminantDtoToDiscriminant(dtoToUpdate);
        final Discriminant discriminantFromDB = disciminantRepository.getById(discriminantToUpdate.getId());
        if (discriminantToUpdate.getId().equals(discriminantFromDB.getId())) {
            final Discriminant discriminant = disciminantRepository.save(discriminantToUpdate);
            return discriminantMapper.disciminantToDiscriminantDto(discriminant);
        } else {
            throw new IllegalArgumentException();
        }

    }


}
