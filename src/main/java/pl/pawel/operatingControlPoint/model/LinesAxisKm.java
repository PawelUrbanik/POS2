package pl.pawel.operatingControlPoint.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import pl.pawel.line.model.Line;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LinesAxisKm implements Serializable {

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
    @JsonIgnore
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
