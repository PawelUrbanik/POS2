package pl.pawel.model.edge;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawel.model.platform.Platform;
import pl.pawel.track.model.Track;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Edge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String egdeName;
    @OneToMany(mappedBy = "edge")
    private Set<Track> tracks;
    @ManyToOne
    private Platform platform;

    @Override
    public int hashCode() {
        return Objects.hash(id, egdeName, tracks, platform);
    }
        /**
     * Update object
     * @param toUpdate
     */
    public void updateFrom(Edge toUpdate) {
        setEgdeName(toUpdate.getEgdeName());
        setPlatform(toUpdate.getPlatform());
        setTracks(toUpdate.getTracks());
    }
}
