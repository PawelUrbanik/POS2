package pl.pawel.operatingControlPoint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.pawel.discriminant.mapper.DiscriminantMapper;
import pl.pawel.operatingControlPoint.mapper.OperatingControlPointMapper;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;
import pl.pawel.operatingControlPoint.model.OperatingControlPointFormDto;
import pl.pawel.operatingControlPoint.model.OperatingControlPointRowDto;
import pl.pawel.operatingControlPoint.repository.OperatingControlPointRepository;
import pl.pawel.railwayDepartment.model.RailwayDepartment;
import pl.pawel.railwayDepartment.repository.RailwayDepartmentRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OperatingControlPointServiceImpl implements OperatingControlPointService {


    private final OperatingControlPointRepository repository;
    private final OperatingControlPointMapper mapper;
    private final DiscriminantMapper discriminantMapper;
    private final RailwayDepartmentRepository railwayDepartmentRepository;

    @Override
    public Page<OperatingControlPointRowDto> getPage(Pageable pageable) {
        final Page<OperatingControlPoint> page = repository.findAll(pageable);
        return page.map(operatingControlPoint ->
                mapper.entityToRowDto(
                        operatingControlPoint,
                        operatingControlPoint.getPlatforms().size(),
                        operatingControlPoint.getLines().size()));
    }

    public OperatingControlPointFormDto getOne(Long id) {
        final OperatingControlPoint found = repository.getById(id);
        return mapper.entityToFormDto(found);
    }

    @Override
    public OperatingControlPointFormDto createNewOperatingControlPoint(OperatingControlPointFormDto dto) {
        final OperatingControlPoint entity = mapper.formDtoToEntity(dto);
        Optional<RailwayDepartment> department = railwayDepartmentRepository.findById(dto.getRailwayDepartment().id());
        if (department.isPresent()) entity.setRailwayDepartment(department.get());
        final OperatingControlPoint saved = repository.save(entity);
        return mapper.entityToFormDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public OperatingControlPointFormDto updateOperatingControlPoint(OperatingControlPointFormDto dto) {
        OperatingControlPoint entity = repository.getById(dto.getId());
        entity.setPointName(dto.getPointName());
        entity.setLoadingPoint(dto.getLoadingPoint());
        entity.setOtherManager(dto.getOtherManager());
        entity.setDiscriminant(discriminantMapper.discriminantDtoToDiscriminant(dto.getDiscriminant()));
        Optional<RailwayDepartment> department = railwayDepartmentRepository.findById(dto.getRailwayDepartment().id());
        if (department.isPresent()) entity.setRailwayDepartment(department.get());
        final OperatingControlPoint saved = repository.save(entity);
        return mapper.entityToFormDto(saved);
    }
}
