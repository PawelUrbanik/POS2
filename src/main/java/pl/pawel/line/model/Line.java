package pl.pawel.line.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;

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
    @OneToMany(mappedBy = "line")
    private Set<OperatingControlPoint> controlPoints;
}
