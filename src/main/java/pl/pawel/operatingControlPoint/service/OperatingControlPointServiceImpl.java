package pl.pawel.operatingControlPoint.service;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.pawel.discriminant.mapper.DiscriminantMapper;
import pl.pawel.operatingControlPoint.mapper.OperatingControlPointMapper;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;
import pl.pawel.operatingControlPoint.model.OperatingControlPointFormDto;
import pl.pawel.operatingControlPoint.model.OperatingControlPointRowDto;
import pl.pawel.operatingControlPoint.model.OperatingControlPointSearchCriteria;
import pl.pawel.operatingControlPoint.repository.OperatingControlPointRepository;
import pl.pawel.railwayDepartment.model.RailwayDepartment;
import pl.pawel.railwayDepartment.repository.RailwayDepartmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OperatingControlPointServiceImpl implements OperatingControlPointService {


    private final OperatingControlPointRepository repository;
    private final OperatingControlPointMapper mapper;
    private final DiscriminantMapper discriminantMapper;
    private final RailwayDepartmentRepository railwayDepartmentRepository;

    @Override
    public Page<OperatingControlPointRowDto> getPage(Pageable pageable, OperatingControlPointSearchCriteria criteria) {
        final Page<OperatingControlPoint> page;

        if (criteria == null) {
            page = repository.findAll(pageable);
        } else {
            Specification spec = createSpecification(criteria);
            page = repository.findAll(spec, pageable);
        }

        return page.map(operatingControlPoint ->
                mapper.entityToRowDto(
                        operatingControlPoint,
                        operatingControlPoint.getPlatforms().size(),
                        operatingControlPoint.getLines().size()));
    }

    private Specification<OperatingControlPoint> createSpecification(OperatingControlPointSearchCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.name() != null && !criteria.name().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("pointName"), criteria.name()+"%"  ));
            }

            if (criteria.discriminantId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("discriminant").get("id"), criteria.discriminantId()));
            }

            if (criteria.departmentId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("railwayDepartment").get("id"), criteria.departmentId()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

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
