package pl.pawel.platform.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pawel.edge.model.Edge;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "platform_sequence")
    @SequenceGenerator(name = "platform_sequence", sequenceName = "platform_sequence", allocationSize = 1)
    private Long id;
    private String platformNumber;
    private Double height;
    private Double length;
    private boolean requestStop;
    @OneToMany(mappedBy = "platform", fetch = FetchType.LAZY)
    private Set<Edge> edges;
    @ManyToOne
    @JoinColumn(
            name = "operating_control_point_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private OperatingControlPoint operatingControlPoint;
}
