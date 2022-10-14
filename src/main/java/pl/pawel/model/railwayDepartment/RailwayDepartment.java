package pl.pawel.model.railwayDepartment;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawel.model.operatingControlPoint.OperatingControlPoint;

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
}
