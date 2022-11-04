package pl.pawel.line.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.pawel.line.model.Line;

@RepositoryRestResource
public interface LineRepository extends JpaRepository<Line, Long> {
}
