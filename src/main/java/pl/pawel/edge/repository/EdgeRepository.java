package pl.pawel.edge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.pawel.edge.model.Edge;

@RepositoryRestResource
public interface EdgeRepository extends JpaRepository<Edge, Long> {
}
