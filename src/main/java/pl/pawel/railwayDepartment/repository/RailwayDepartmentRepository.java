package pl.pawel.railwayDepartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.pawel.railwayDepartment.model.RailwayDepartment;

import java.util.List;

public interface RailwayDepartmentRepository {
    List<RailwayDepartment> findAll();
}
