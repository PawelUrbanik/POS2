package pl.pawel.platform.repository;

import pl.pawel.platform.model.Platform;

import java.util.List;

public interface PlatformRepository {

    List<Platform> getAllByOperatingControlPoint(Long id);
    Platform getById(Long id);
}