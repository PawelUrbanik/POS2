package pl.pawel.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int lineNumber;
    private String lineName;
    private Double startKm;
    private Double endKm;
    @OneToMany(mappedBy = "line")
    private Set<OperatingControlPoint> controlPoints;

}
