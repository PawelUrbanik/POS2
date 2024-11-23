package pl.pawel.operatingControlPoint.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pawel.discriminant.model.Discriminant;
import pl.pawel.platform.model.Platform;
import pl.pawel.railwayDepartment.model.RailwayDepartment;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OperatingControlPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operating_control_point_sequence")
    @SequenceGenerator(name = "operating_control_point_sequence", sequenceName = "operating_control_point_sequence", allocationSize = 1)
    private Long id;
    private String pointName;
    private Boolean loadingPoint;
    private Boolean otherManager;
    @OneToMany(mappedBy = "operatingControlPoint", fetch = FetchType.LAZY)
    private Set<Platform> platforms;
    @OneToOne
    private Discriminant discriminant;

    @JsonBackReference(value = "pointDepartmentRef")
    @ManyToOne(
            cascade = CascadeType.REFRESH
    )
    private RailwayDepartment railwayDepartment;
    @JsonManagedReference(value = "pointLinesAxisRef")
    @OneToMany(
            mappedBy = "operatingControlPoint",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private Set<LinesAxisKm> lines;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperatingControlPoint that = (OperatingControlPoint) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OperatingControlPoint{" +
                "id=" + id +
                ", pointName='" + pointName + '\'' +
                ", loadingPoint=" + loadingPoint +
                ", otherManager=" + otherManager +
                ", discriminant=" + discriminant +
                '}';
    }
}
