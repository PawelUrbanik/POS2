package pl.pawel.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int lineNumber;
    private String lineName;
    private Double startKm;
    private Double endKm;
    @OneToMany(mappedBy = "line")
    private Set<OperatingControlPoint> controlPoints;

    public Line() {
    }

    public Line(int lineNumber, String lineName, Double startKm, Double endKm, Set<OperatingControlPoint> controlPoints) {
        this.lineNumber = lineNumber;
        this.lineName = lineName;
        this.startKm = startKm;
        this.endKm = endKm;
        this.controlPoints = controlPoints;
    }

    public Line(Long id, int lineNumber, String lineName, Double startKm, Double endKm, Set<OperatingControlPoint> controlPoints) {
        this.id = id;
        this.lineNumber = lineNumber;
        this.lineName = lineName;
        this.startKm = startKm;
        this.endKm = endKm;
        this.controlPoints = controlPoints;
    }


    public Double getLength(){
        return endKm-startKm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Double getStartKm() {
        return startKm;
    }

    public void setStartKm(Double startKm) {
        this.startKm = startKm;
    }

    public Double getEndKm() {
        return endKm;
    }

    public void setEndKm(Double endKm) {
        this.endKm = endKm;
    }

    public Set<OperatingControlPoint> getControlPoints() {
        return controlPoints;
    }

    public void setControlPoints(Set<OperatingControlPoint> controlPoints) {
        this.controlPoints = controlPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return lineNumber == line.lineNumber && Objects.equals(id, line.id) && Objects.equals(lineName, line.lineName) && Objects.equals(startKm, line.startKm) && Objects.equals(endKm, line.endKm) && Objects.equals(controlPoints, line.controlPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lineNumber, lineName, startKm, endKm, controlPoints);
    }

    //TODO: Control points pokazywanie obiektów leżących na lini
    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", lineNumber=" + lineNumber +
                ", lineName='" + lineName + '\'' +
                ", startKm=" + startKm +
                ", endKm=" + endKm +
                ", controlPoints=" + controlPoints.stream()
                .map(OperatingControlPoint::getPointName) +
                '}';
    }
}
