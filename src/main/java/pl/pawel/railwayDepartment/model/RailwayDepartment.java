package pl.pawel.railwayDepartment.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import pl.pawel.line.model.Line;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RailwayDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(
            mappedBy = "railwayDepartment",
            orphanRemoval = false,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference(value = "pointDepartmentRef")
    private Set<OperatingControlPoint> operatingControlPoints;

    @ManyToMany(
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "departments_lines",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "line_id")
    )
    private Set<Line> lines;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RailwayDepartment that = (RailwayDepartment) o;
        return id.equals(that.id) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "RailwayDepartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
