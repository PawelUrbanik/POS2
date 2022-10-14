package pl.pawel.model.platform;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawel.model.edge.Edge;
import pl.pawel.model.operatingControlPoint.OperatingControlPoint;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
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
