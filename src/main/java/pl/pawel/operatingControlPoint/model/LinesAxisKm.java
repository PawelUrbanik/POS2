package pl.pawel.operatingControlPoint.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pawel.line.model.Line;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

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
    @ManyToOne
    @JoinColumn(
            name = "operating_control_point_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private OperatingControlPoint operatingControlPoint;
}
