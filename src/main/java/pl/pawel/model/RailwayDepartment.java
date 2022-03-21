package pl.pawel.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RailwayDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "railwayDepartment")
    private Set<OperatingControlPoint> operatingControlPoints;
}
