package pl.pawel.railwayDepartment.repository;

import pl.pawel.railwayDepartment.model.RailwayDepartment;

import java.util.List;
import java.util.Optional;

public interface RailwayDepartmentRepository {
    List<RailwayDepartment> findAll();
    Optional<RailwayDepartment> findById(Long id);
}
