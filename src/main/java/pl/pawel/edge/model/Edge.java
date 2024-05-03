package pl.pawel.edge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pawel.platform.model.Platform;
import pl.pawel.track.model.Track;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
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

    public Edge(String egdeName, Platform platform) {
        this.egdeName = egdeName;
        this.platform =platform;
    }

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
