package pl.pawel.railwayDepartment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;
import pl.pawel.railwayDepartment.model.RailwayDepartmentDto;
import pl.pawel.railwayDepartment.service.RailwayDepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin("http://localhost:4200/")
public class RailwayDepartmentController {

    private final RailwayDepartmentService railwayDepartmentService;

    public RailwayDepartmentController(RailwayDepartmentService railwayDepartmentService) {
        this.railwayDepartmentService = railwayDepartmentService;
    }


    @GetMapping
    public ResponseEntity<List<RailwayDepartmentDto>> getAllDepartments() {
        List<RailwayDepartmentDto> departments = railwayDepartmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
}


