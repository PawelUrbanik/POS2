package pl.pawel.operatingControlPoint.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;

public interface OperatingControlPointRepository {

    Page<OperatingControlPoint> findAll(Pageable pageable);
}
