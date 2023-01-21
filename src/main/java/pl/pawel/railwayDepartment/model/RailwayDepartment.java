package pl.pawel.railwayDepartment.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawel.line.model.Line;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class RailwayDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "railwayDepartment")
    private Set<OperatingControlPoint> operatingControlPoints;

    @ManyToMany(
            cascade = CascadeType.MERGE
    )
    @JoinTable(
            name = "departments_lines",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "line_id")
    )
    private Set<Line> lines;

}
