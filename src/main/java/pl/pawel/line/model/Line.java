package pl.pawel.line.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pawel.operatingControlPoint.model.LinesAxisKm;
import pl.pawel.railwayDepartment.model.RailwayDepartment;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int lineNumber;
    private String lineName;
    private Double startKm;
    private Double endKm;
    @OneToMany(
            mappedBy = "line",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private Set<LinesAxisKm> controlPointsAxisKm;

    @ManyToMany(mappedBy = "lines")
    private Set<RailwayDepartment> departments;
}
