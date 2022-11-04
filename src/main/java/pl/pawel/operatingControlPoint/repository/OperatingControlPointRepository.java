package pl.pawel.operatingControlPoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;

@RepositoryRestResource
public interface OperatingControlPointRepository extends JpaRepository<OperatingControlPoint, Long> {
}
