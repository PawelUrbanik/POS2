package pl.pawel.operatingControlPoint.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pawel.operatingControlPoint.model.OperatingControlPointFormDto;
import pl.pawel.operatingControlPoint.model.OperatingControlPointRowDto;
import pl.pawel.operatingControlPoint.model.OperatingControlPointSearchCriteria;

public interface OperatingControlPointService {

    Page<OperatingControlPointRowDto> getPage(Pageable pageable, OperatingControlPointSearchCriteria criteria);
    OperatingControlPointFormDto getOne(Long id);
    OperatingControlPointFormDto createNewOperatingControlPoint(OperatingControlPointFormDto dto);
    void deleteById(Long id);
    OperatingControlPointFormDto updateOperatingControlPoint(OperatingControlPointFormDto dto);
}
