package pl.pawel.model.operatingControlPoint;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawel.discriminant.model.Discriminant;
import pl.pawel.model.line.Line;
import pl.pawel.discriminant.model.Discriminant;

import pl.pawel.model.loadingPoint.LoadingPoint;
import pl.pawel.model.platform.Platform;
import pl.pawel.model.railwayDepartment.RailwayDepartment;

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
