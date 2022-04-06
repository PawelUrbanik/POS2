package pl.pawel.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class OperatingControlPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pointName;
    @OneToMany(mappedBy = "operatingControlPoint")
    private Set<Platform> platforms;

    @OneToOne
    private Discriminant discriminant;
    @OneToOne
    private LoadingPoint loadingPoint;
    @ManyToOne
    private RailwayDepartment railwayDepartment;

    @ManyToOne
    private Line line;


    public OperatingControlPoint() {
    }

    public OperatingControlPoint(String pointName, Set<Platform> platforms, Discriminant discriminant, LoadingPoint loadingPoint, RailwayDepartment railwayDepartment, Line line) {
        this.pointName = pointName;
        this.platforms = platforms;
        this.discriminant = discriminant;
        this.loadingPoint = loadingPoint;
        this.railwayDepartment = railwayDepartment;
        this.line = line;
    }

    public OperatingControlPoint(Long id, String pointName, Set<Platform> platforms, Discriminant discriminant, LoadingPoint loadingPoint, RailwayDepartment railwayDepartment, Line line) {
        this.id = id;
        this.pointName = pointName;
        this.platforms = platforms;
        this.discriminant = discriminant;
        this.loadingPoint = loadingPoint;
        this.railwayDepartment = railwayDepartment;
        this.line = line;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Set<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Set<Platform> platforms) {
        this.platforms = platforms;
    }

    public Discriminant getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(Discriminant discriminant) {
        this.discriminant = discriminant;
    }

    public LoadingPoint getLoadingPoint() {
        return loadingPoint;
    }

    public void setLoadingPoint(LoadingPoint loadingPoint) {
        this.loadingPoint = loadingPoint;
    }

    public RailwayDepartment getRailwayDepartment() {
        return railwayDepartment;
    }

    public void setRailwayDepartment(RailwayDepartment railwayDepartment) {
        this.railwayDepartment = railwayDepartment;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperatingControlPoint that = (OperatingControlPoint) o;
        return Objects.equals(id, that.id) && Objects.equals(pointName, that.pointName) && Objects.equals(platforms, that.platforms) && discriminant == that.discriminant && Objects.equals(loadingPoint, that.loadingPoint) && Objects.equals(railwayDepartment, that.railwayDepartment) && Objects.equals(line, that.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pointName, platforms, discriminant, loadingPoint, railwayDepartment, line);
    }

    @Override
    public String toString() {
        return "OperatingControlPoint{" +
                "id=" + id +
                ", pointName='" + pointName + '\'' +
                ", platforms=" + platforms.toString() +
                ", discriminant=" + discriminant +
                ", loadingPoint=" + loadingPoint.getName() +
                ", railwayDepartment=" + railwayDepartment.getName() +
                ", line=" + line +
                '}';
    }
}
