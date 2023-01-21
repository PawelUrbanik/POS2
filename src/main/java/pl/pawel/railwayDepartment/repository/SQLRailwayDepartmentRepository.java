package pl.pawel.railwayDepartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawel.railwayDepartment.model.RailwayDepartment;

@Repository
public interface SQLRailwayDepartmentRepository extends RailwayDepartmentRepository, JpaRepository<RailwayDepartment, Long> {
}
