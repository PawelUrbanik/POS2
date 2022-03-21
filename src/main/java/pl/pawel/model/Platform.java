package pl.pawel.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double height;
    private Double length;
    private boolean requestStop;

    @OneToMany(mappedBy = "platform")
    private Set<Edge> edges;

    @ManyToOne
    private OperatingControlPoint operatingControlPoint;

}
