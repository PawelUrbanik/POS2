package pl.pawel.model.loadingPoint;

import pl.pawel.model.operatingControlPoint.OperatingControlPoint;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class LoadingPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private boolean roundTheClock;
    private LocalTime openFrom;
    private LocalTime openTo;
    @OneToOne
    private OperatingControlPoint operatingControlPoint;

    public LoadingPoint() {
    }

    public LoadingPoint(Long id, String name, boolean roundTheClock, LocalTime openFrom, LocalTime openTo, OperatingControlPoint operatingControlPoint) {
        this.id = id;
        this.name = name;
        this.roundTheClock = roundTheClock;
        this.openFrom = openFrom;
        this.openTo = openTo;
        this.operatingControlPoint = operatingControlPoint;
    }

    public LoadingPoint(String name, boolean roundTheClock, LocalTime openFrom, LocalTime openTo, OperatingControlPoint operatingControlPoint) {
        this.name = name;
        this.roundTheClock = roundTheClock;
        this.openFrom = openFrom;
        this.openTo = openTo;
        this.operatingControlPoint = operatingControlPoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRoundTheClock() {
        return roundTheClock;
    }

    public void setRoundTheClock(boolean roundTheClock) {
        this.roundTheClock = roundTheClock;
    }

    public LocalTime getOpenFrom() {
        return openFrom;
    }

    public void setOpenFrom(LocalTime openFrom) {
        this.openFrom = openFrom;
    }

    public LocalTime getOpenTo() {
        return openTo;
    }

    public void setOpenTo(LocalTime openTo) {
        this.openTo = openTo;
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
        LoadingPoint that = (LoadingPoint) o;
        return roundTheClock == that.roundTheClock && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(openFrom, that.openFrom) && Objects.equals(openTo, that.openTo) && Objects.equals(operatingControlPoint, that.operatingControlPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, roundTheClock, openFrom, openTo, operatingControlPoint);
    }

    @Override
    public String toString() {
        return "LoadingPoint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roundTheClock=" + roundTheClock +
                ", openFrom=" + openFrom +
                ", openTo=" + openTo +
                ", operatingControlPoint=" + operatingControlPoint.getPointName() +
                '}';
    }
}
