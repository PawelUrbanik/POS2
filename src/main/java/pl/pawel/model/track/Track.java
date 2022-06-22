package pl.pawel.model.track;

import pl.pawel.model.edge.Edge;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer trackNumber;
    private Double axisKm;
    @ManyToOne
    @JoinColumn(name = "edge_id", nullable = false)
    private Edge edge;

    public Track(Long id, Integer trackNumber, Double axisKm, Edge edge) {
        this.id = id;
        this.trackNumber = trackNumber;
        this.axisKm = axisKm;
        this.edge = edge;
    }

    public Track() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Double getAxisKm() {
        return axisKm;
    }

    public void setAxisKm(Double axisKm) {
        this.axisKm = axisKm;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(id, track.id) && Objects.equals(trackNumber, track.trackNumber) && Objects.equals(axisKm, track.axisKm) && Objects.equals(edge, track.edge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trackNumber, axisKm, edge);
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", trackNumber=" + trackNumber +
                ", axisKm=" + axisKm +
                ", edge=" + edge.getEgdeName() +
                '}';
    }
}
