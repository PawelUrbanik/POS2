package pl.pawel.loadingPoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.pawel.loadingPoint.model.LoadingPoint;

@RepositoryRestResource
public interface LoadingPointRepository extends JpaRepository<LoadingPoint, Long> {
}
