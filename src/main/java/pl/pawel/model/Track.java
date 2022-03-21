package pl.pawel.model;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(id, track.id) && Objects.equals(trackNumber, track.trackNumber) && Objects.equals(axisKm, track.axisKm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trackNumber, axisKm);
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", trackNumber=" + trackNumber +
                ", axisKm=" + axisKm +
                '}';
    }
}
