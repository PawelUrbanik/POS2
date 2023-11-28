package pl.pawel.platform.service;

import pl.pawel.platform.model.PlatformSelectOptionDto;

import java.util.List;

public interface PlatformService {

    List<PlatformSelectOptionDto> getAllByOperatingControlPoint(Long pointId);
}
