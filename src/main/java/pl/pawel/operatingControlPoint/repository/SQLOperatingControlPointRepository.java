package pl.pawel.operatingControlPoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;

@Repository
public interface SQLOperatingControlPointRepository extends OperatingControlPointRepository, JpaRepository<OperatingControlPoint, Long>, JpaSpecificationExecutor<OperatingControlPoint> {
}
