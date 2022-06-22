package pl.pawel.model.platform;

import pl.pawel.model.edge.Edge;
import pl.pawel.model.operatingControlPoint.OperatingControlPoint;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer platformNumber;
    private Double height;
    private Double length;
    private boolean requestStop;

    @OneToMany(mappedBy = "platform")
    private Set<Edge> edges;

    @ManyToOne
    private OperatingControlPoint operatingControlPoint;

    public Platform() {
    }

    public Platform(Integer platformNumber, Double height, Double length, boolean requestStop, Set<Edge> edges, OperatingControlPoint operatingControlPoint) {
        this.platformNumber = platformNumber;
        this.height = height;
        this.length = length;
        this.requestStop = requestStop;
        this.edges = edges;
        this.operatingControlPoint = operatingControlPoint;
    }

    public Platform(Long id, Integer platformNumber, Double height, Double length, boolean requestStop, Set<Edge> edges, OperatingControlPoint operatingControlPoint) {
        this.id = id;
        this.platformNumber = platformNumber;
        this.height = height;
        this.length = length;
        this.requestStop = requestStop;
        this.edges = edges;
        this.operatingControlPoint = operatingControlPoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlatformNumber() {
        return platformNumber;
    }

    public void setPlatformNumber(Integer platformNumber) {
        this.platformNumber = platformNumber;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public boolean isRequestStop() {
        return requestStop;
    }

    public void setRequestStop(boolean requestStop) {
        this.requestStop = requestStop;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }

    public OperatingControlPoint getOperatingControlPoint() {
        return operatingControlPoint;
    }

    public void setOperatingControlPoint(OperatingControlPoint operatingControlPoint) {
        this.operatingControlPoint = operatingControlPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Platform platform = (Platform) o;
        return requestStop == platform.requestStop && Objects.equals(id, platform.id) && Objects.equals(platformNumber, platform.platformNumber) && Objects.equals(height, platform.height) && Objects.equals(length, platform.length) && Objects.equals(edges, platform.edges) && Objects.equals(operatingControlPoint, platform.operatingControlPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, platformNumber, height, length, requestStop, edges, operatingControlPoint);
    }

    @Override
    public String toString() {
        return "Platform{" +
                "id=" + id +
                ", platformNumber=" + platformNumber +
                ", height=" + height +
                ", length=" + length +
                ", requestStop=" + requestStop +
                ", edges=" + edges.toString() +
                ", operatingControlPoint=" + operatingControlPoint.getPointName() +
                '}';
    }
}
