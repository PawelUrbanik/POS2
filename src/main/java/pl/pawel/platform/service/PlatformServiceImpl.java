package pl.pawel.platform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pawel.platform.mapper.PlatformMapper;
import pl.pawel.platform.model.Platform;
import pl.pawel.platform.model.PlatformSelectOptionDto;
import pl.pawel.platform.model.PlatformTabTableRowDto;
import pl.pawel.platform.repository.PlatformRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService{


    private final PlatformRepository platformRepository;
    private final PlatformMapper platformMapper;
    @Override
    public List<PlatformSelectOptionDto> getAllByOperatingControlPoint(Long pointId) {

        final List<Platform> platforms = platformRepository.getAllByOperatingControlPoint(pointId);

        final List<PlatformSelectOptionDto> list = platforms.stream().map(platformMapper::entityToDto).collect(Collectors.toList());

        return list;
    }

    @Override
    public List<PlatformTabTableRowDto> getAllTabRowDtosByPointId(Long pointId) {

        final List<Platform> platforms = platformRepository.getAllByOperatingControlPoint(pointId);
        final List<PlatformTabTableRowDto> list = platforms.stream()
                .map(platformMapper::entityToTableRowDto)
                .collect(Collectors.toList());

        return list;
    }
}
