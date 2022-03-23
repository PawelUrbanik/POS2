package pl.pawel.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class RailwayDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "railwayDepartment")
    private Set<OperatingControlPoint> operatingControlPoints;

    public RailwayDepartment() {
    }

    public RailwayDepartment(String name, Set<OperatingControlPoint> operatingControlPoints) {
        this.name = name;
        this.operatingControlPoints = operatingControlPoints;
    }

    public RailwayDepartment(Long id, String name, Set<OperatingControlPoint> operatingControlPoints) {
        this.id = id;
        this.name = name;
        this.operatingControlPoints = operatingControlPoints;
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

    public Set<OperatingControlPoint> getOperatingControlPoints() {
        return operatingControlPoints;
    }

    public void setOperatingControlPoints(Set<OperatingControlPoint> operatingControlPoints) {
        this.operatingControlPoints = operatingControlPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RailwayDepartment that = (RailwayDepartment) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(operatingControlPoints, that.operatingControlPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, operatingControlPoints);
    }

    @Override
    public String toString() {
        return "RailwayDepartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", operatingControlPoints=" + operatingControlPoints.toString() +
                '}';
    }
}
