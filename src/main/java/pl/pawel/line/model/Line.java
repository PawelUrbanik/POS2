package pl.pawel.line.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;
import pl.pawel.railwayDepartment.model.RailwayDepartment;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int lineNumber;
    private String lineName;
    private Double startKm;
    private Double endKm;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "lines_points",
            joinColumns = @JoinColumn(name = "line_id"),
            inverseJoinColumns = @JoinColumn(name = "point_id")
    )
    private Set<OperatingControlPoint> controlPoints;

    @ManyToMany(mappedBy = "lines")
    private Set<RailwayDepartment> departments;
}
