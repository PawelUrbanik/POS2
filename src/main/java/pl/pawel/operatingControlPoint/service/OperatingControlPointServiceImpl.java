package pl.pawel.operatingControlPoint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.pawel.operatingControlPoint.mapper.OperatingControlPointMapper;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;
import pl.pawel.operatingControlPoint.model.OperatingControlPointRowDto;
import pl.pawel.operatingControlPoint.repository.OperatingControlPointRepository;

@RequiredArgsConstructor
@Service
public class OperatingControlPointServiceImpl implements OperatingControlPointService{


    private final OperatingControlPointRepository repository;
    private final OperatingControlPointMapper mapper;
    @Override
    public Page<OperatingControlPointRowDto> getPage(Pageable pageable) {
        final Page<OperatingControlPoint> page = repository.findAll(pageable);
        return page.map(operatingControlPoint ->
                mapper.entityToRowDto(
                        operatingControlPoint,
                        operatingControlPoint.getPlatforms().size(),
                        operatingControlPoint.getLines().size()));
    }
}
