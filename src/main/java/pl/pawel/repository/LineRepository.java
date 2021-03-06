package pl.pawel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.pawel.model.line.Line;

@RepositoryRestResource
public interface LineRepository extends JpaRepository<Line, Long> {
}
