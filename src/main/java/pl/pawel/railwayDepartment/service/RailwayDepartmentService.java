package pl.pawel.railwayDepartment.service;

import org.springframework.stereotype.Service;
import pl.pawel.railwayDepartment.model.RailwayDepartmentDto;

import java.util.List;

public interface RailwayDepartmentService {

    List<RailwayDepartmentDto> getAllDepartments();
}
