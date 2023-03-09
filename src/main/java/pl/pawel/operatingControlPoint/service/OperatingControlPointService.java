package pl.pawel.operatingControlPoint.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pawel.operatingControlPoint.model.OperatingControlPointRowDto;

public interface OperatingControlPointService {

    Page<OperatingControlPointRowDto> getPage(Pageable pageable);

}
