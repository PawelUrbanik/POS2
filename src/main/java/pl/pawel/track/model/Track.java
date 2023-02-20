package pl.pawel.track.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import pl.pawel.edge.model.Edge;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String trackNumber;
    private Double axisKm;
    @ManyToOne
    @Nullable
    @JoinColumn(name = "edge_id", nullable = true)
    private Edge edge;
}
