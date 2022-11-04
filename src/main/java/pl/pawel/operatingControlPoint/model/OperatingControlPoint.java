package pl.pawel.operatingControlPoint.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawel.line.model.Line;
import pl.pawel.discriminant.model.Discriminant;
import pl.pawel.loadingPoint.model.LoadingPoint;
import pl.pawel.platform.model.Platform;
import pl.pawel.railwayDepartment.model.RailwayDepartment;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class OperatingControlPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pointName;
    @OneToMany(mappedBy = "operatingControlPoint")
    private Set<Platform> platforms;
    @OneToOne
    private Discriminant discriminant;
    @OneToOne
    private LoadingPoint loadingPoint;
    @ManyToOne
    private RailwayDepartment railwayDepartment;
    @ManyToOne
    private Line line;
}