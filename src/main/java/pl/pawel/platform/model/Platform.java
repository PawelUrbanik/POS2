package pl.pawel.platform.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pawel.edge.model.Edge;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String platformNumber;
    private Double height;
    private Double length;
    private boolean requestStop;
    @OneToMany(mappedBy = "platform")
    private Set<Edge> edges;
    @ManyToOne
    private OperatingControlPoint operatingControlPoint;
}
