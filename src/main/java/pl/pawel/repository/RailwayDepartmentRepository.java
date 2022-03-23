package pl.pawel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.pawel.model.RailwayDepartment;

@RepositoryRestResource
public interface RailwayDepartmentRepository extends JpaRepository<RailwayDepartment, Long> {
}
