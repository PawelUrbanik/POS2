package pl.pawel.operatingControlPoint.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;
import pl.pawel.operatingControlPoint.model.OperatingControlPointRowDto;

public interface OperatingControlPointRepository {

    Page<OperatingControlPoint> findAll(Pageable pageable);
    OperatingControlPoint getById(Long id);
    OperatingControlPoint save(OperatingControlPoint entity);
    void deleteById(Long id);
}
