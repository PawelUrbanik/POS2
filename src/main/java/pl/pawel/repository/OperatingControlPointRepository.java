package pl.pawel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.pawel.model.OperatingControlPoint;

@RepositoryRestResource
public interface OperatingControlPointRepository extends JpaRepository<OperatingControlPoint, Long> {
}
