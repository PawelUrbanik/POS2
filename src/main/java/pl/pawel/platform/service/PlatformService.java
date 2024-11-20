package pl.pawel.platform.service;

import pl.pawel.platform.model.PlatformSelectOptionDto;
import pl.pawel.platform.model.PlatformTabTableRowDto;

import java.util.List;

public interface PlatformService {

    List<PlatformSelectOptionDto> getAllByOperatingControlPoint(Long pointId);

    List<PlatformTabTableRowDto> getAllTabRowDtosByPointId(Long pointId);
}
