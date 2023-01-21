package pl.pawel.railwayDepartment.service;

import org.springframework.stereotype.Service;
import pl.pawel.railwayDepartment.mapper.RailwayDepartmentMapper;
import pl.pawel.railwayDepartment.model.RailwayDepartment;
import pl.pawel.railwayDepartment.model.RailwayDepartmentDto;
import pl.pawel.railwayDepartment.repository.RailwayDepartmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RailwayDepartmentServiceImpl implements RailwayDepartmentService {

    private final RailwayDepartmentRepository railwayDepartmentRepository;
    private final RailwayDepartmentMapper railwayDepartmentMapper;

    public RailwayDepartmentServiceImpl(RailwayDepartmentRepository railwayDepartmentRepository, RailwayDepartmentMapper railwayDepartmentMapper) {
        this.railwayDepartmentRepository = railwayDepartmentRepository;
        this.railwayDepartmentMapper = railwayDepartmentMapper;
    }

    @Override
    public List<RailwayDepartmentDto> getAllDepartments() {
        final List<RailwayDepartment> departments = railwayDepartmentRepository.findAll();
        List<RailwayDepartmentDto> dtos = departments.stream().map(railwayDepartmentMapper::railwayDepartmentToDto).toList();
        return dtos;
    }
}
