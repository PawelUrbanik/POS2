package pl.pawel.platform.service;

import pl.pawel.platform.model.PlatformDto;
import pl.pawel.platform.model.PlatformSelectOptionDto;
import pl.pawel.platform.model.PlatformTabTableRowDto;
import pl.pawel.platform.model.SavePlatformDto;

import java.util.List;

public interface PlatformService {

    List<PlatformSelectOptionDto> getAllByOperatingControlPoint(Long pointId);

    List<PlatformTabTableRowDto> getAllTabRowDtosByPointId(Long pointId);

    PlatformDto getPlatform(Long platformId);

    PlatformDto updatePlatform(PlatformDto platformDto);

    PlatformDto savePlatform(SavePlatformDto platformDto, Long pointId);

    void deletePlatform(Long id);
}
