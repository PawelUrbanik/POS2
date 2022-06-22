package pl.pawel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.pawel.model.platform.Platform;

@RepositoryRestResource
public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
