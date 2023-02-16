package pl.pawel.operatingControlPoint.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawel.discriminant.model.Discriminant;
import pl.pawel.line.model.Line;
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
    private Boolean loadingPoint;
//    private Double axisKm;
    private Boolean otherManager;
    @OneToMany(mappedBy = "operatingControlPoint")
    private Set<Platform> platforms;
    @OneToOne
    private Discriminant discriminant;
    @ManyToOne
    private RailwayDepartment railwayDepartment;
    @OneToMany(
            mappedBy = "operatingControlPoint",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private Set<LinesAxisKm> lines;
}
