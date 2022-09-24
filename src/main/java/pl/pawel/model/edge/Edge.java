package pl.pawel.model.edge;

import pl.pawel.model.platform.Platform;
import pl.pawel.track.model.Track;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Edge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String egdeName;
    @OneToMany(mappedBy = "edge")
    private Set<Track> tracks;
    @ManyToOne
    private Platform platform;

    public Edge() {
    }

    public Edge(String egdeName, Set<Track> tracks, Platform platform) {
        this.egdeName = egdeName;
        this.tracks = tracks;
        this.platform = platform;
    }

    public Edge(Long id, String egdeName, Set<Track> tracks, Platform platform) {
        this.id = id;
        this.egdeName = egdeName;
        this.tracks = tracks;
        this.platform = platform;
    }

    public Edge(String egdeName, Platform platform) {
        this.egdeName = egdeName;
        this.platform= platform;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEgdeName() {
        return egdeName;
    }

    public void setEgdeName(String egdeName) {
        this.egdeName = egdeName;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(id, edge.id) && Objects.equals(egdeName, edge.egdeName) && Objects.equals(tracks, edge.tracks) && Objects.equals(platform, edge.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, egdeName, tracks, platform);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "id=" + id +
                ", egdeName='" + egdeName + '\'' +
                ", tracks=" + tracks +
                ", platformNumber=" + platform.getPlatformNumber() +
                '}';
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
