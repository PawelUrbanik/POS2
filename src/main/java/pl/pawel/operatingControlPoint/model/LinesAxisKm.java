package pl.pawel.operatingControlPoint.model;


import lombok.Data;
import pl.pawel.line.model.Line;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
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
    @ManyToOne
    @JoinColumn(
            name = "operating_control_point_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private OperatingControlPoint operatingControlPoint;
}
