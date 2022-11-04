package pl.pawel.track.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import pl.pawel.edge.model.Edge;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer trackNumber;
    private Double axisKm;
    @ManyToOne
    @Nullable
    @JoinColumn(name = "edge_id", nullable = true)
    private Edge edge;
}
