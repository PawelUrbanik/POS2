package pl.pawel.operatingControlPoint.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;

public interface OperatingControlPointRepository {

    Page<OperatingControlPoint> findAll(Pageable pageable);
    Page<OperatingControlPoint> findAll(@Nullable Specification<OperatingControlPoint> spec, Pageable pageable);
    OperatingControlPoint getById(Long id);
    OperatingControlPoint save(OperatingControlPoint entity);
    void deleteById(Long id);
}
