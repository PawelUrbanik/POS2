package pl.pawel.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class OperatingControlPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pointName;
    @OneToMany(mappedBy = "operatingControlPoint")
    private Set<Platform> platforms;
    
    private Discriminant discriminant;
//    private LoadingPoint loadingPoint;
//    private RailwayDepartment railwayDepartment;
}
