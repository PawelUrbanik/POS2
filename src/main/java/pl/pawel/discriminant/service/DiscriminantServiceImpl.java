package pl.pawel.discriminant.service;

import org.springframework.stereotype.Service;
import pl.pawel.discriminant.mapper.DiscriminantMapper;
import pl.pawel.discriminant.model.DiscirminantDto;
import pl.pawel.discriminant.model.Discriminant;
import pl.pawel.discriminant.repository.DiscriminantRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscriminantServiceImpl implements DiscriminantService {

    private final DiscriminantRepository discriminantRepository;
    private final DiscriminantMapper discriminantMapper;

    public DiscriminantServiceImpl(DiscriminantRepository discriminantRepository, DiscriminantMapper discriminantMapper) {
        this.discriminantRepository = discriminantRepository;
        this.discriminantMapper = discriminantMapper;
    }

    @Override
    public List<DiscirminantDto> getAllDiscriminants() {
        final List<Discriminant> discriminantList = discriminantRepository.findAll();
        List<DiscirminantDto> discirminantDtos = new ArrayList<>();
        discriminantList.forEach(discriminant -> discirminantDtos.add(discriminantMapper.disciminantToDiscriminantDto(discriminant)));
        return discirminantDtos;
    }

    @Override
    public DiscirminantDto updateDiscriminant(DiscirminantDto dtoToUpdate) {

        final Discriminant discriminantToUpdate = discriminantMapper.discriminantDtoToDiscriminant(dtoToUpdate);
        final Discriminant discriminantFromDB = discriminantRepository.getById(discriminantToUpdate.getId());
        if (discriminantToUpdate.getId().equals(discriminantFromDB.getId())) {
            discriminantToUpdate.setShortcut(discriminantToUpdate.getShortcut().toUpperCase());
            final Discriminant discriminant = discriminantRepository.save(discriminantToUpdate);
            return discriminantMapper.disciminantToDiscriminantDto(discriminant);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public DiscirminantDto createNewDiscriminant(DiscirminantDto dtoToSave) {

        if (!discriminantRepository.existsByShortcut(dtoToSave.getShortcut())) {
            dtoToSave.setShortcut(dtoToSave.getShortcut().toUpperCase());
            final Discriminant savedDiscriminant = discriminantRepository.save(discriminantMapper.discriminantDtoToDiscriminant(dtoToSave));
            return discriminantMapper.disciminantToDiscriminantDto(savedDiscriminant);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void deleteById(Long id) {
        if (discriminantRepository.existsById(id)) {
            discriminantRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
