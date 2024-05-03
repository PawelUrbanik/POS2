package pl.pawel.operatingControlPoint.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pawel.line.model.Line;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LinesAxisKm implements Serializable {

    @JsonBackReference(value = "lineLineAxisKmRef")
    @Id
    @ManyToOne
    @JoinColumn(
            name = "line_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private Line line;
    private Double axisKm;

    @Id
    @JsonBackReference(value = "pointLinesAxisRef")
    @ManyToOne
    @JoinColumn(
            name = "operating_control_point_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private OperatingControlPoint operatingControlPoint;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinesAxisKm that = (LinesAxisKm) o;
        return Objects.equals(line, that.line) && Objects.equals(axisKm, that.axisKm) && Objects.equals(operatingControlPoint, that.operatingControlPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, axisKm, operatingControlPoint);
    }
}
