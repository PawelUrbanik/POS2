package pl.pawel.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pawel.platform.model.Platform;

import java.util.List;

@Repository
public interface SQLPlatformRepository extends PlatformRepository, JpaRepository<Platform, Long> {

    @Query("SELECT p FROM Platform p WHERE p.operatingControlPoint.id = :id")
    List<Platform> getAllByOperatingControlPoint(Long id);
}
