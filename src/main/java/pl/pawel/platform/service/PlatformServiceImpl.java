package pl.pawel.platform.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;
import pl.pawel.operatingControlPoint.repository.OperatingControlPointRepository;
import pl.pawel.platform.mapper.PlatformMapper;
import pl.pawel.platform.model.*;
import pl.pawel.platform.repository.PlatformRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService{


    private final PlatformRepository platformRepository;
    private final PlatformMapper platformMapper;
    private final OperatingControlPointRepository operatingControlPointRepository;

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

    @Override
    public PlatformDto getPlatform(Long platformId) {
        Platform entity = platformRepository.getById(platformId);
        PlatformDto dto = platformMapper.entityToPlatformDto(entity);
        return dto;
    }

    @Override
    public PlatformDto updatePlatform(PlatformDto platformDto) {
        Platform platformFromDB = platformRepository.getById(platformDto.getId());
        platformFromDB.setPlatformNumber(platformDto.getPlatformNumber());
        platformFromDB.setLength(platformDto.getLength());
        platformFromDB.setHeight(platformDto.getHeight());
        platformFromDB.setRequestStop(platformDto.isRequestStop());
        platformFromDB.setEdges(platformDto.getEdges());
        Platform saved = platformRepository.save(platformFromDB);
        PlatformDto savedDto = platformMapper.entityToPlatformDto(saved);

        return savedDto;
    }

    @Override
    @Transactional
    public PlatformDto savePlatform(SavePlatformDto platformDto, Long pointId) {
        Platform platform = platformMapper.saveDtoToEntity(platformDto);
        OperatingControlPoint opc = operatingControlPointRepository.getById(pointId);
        platform.setOperatingControlPoint(opc);
        Platform saved = platformRepository.save(platform);
        return platformMapper.entityToPlatformDto(saved);
    }
}
