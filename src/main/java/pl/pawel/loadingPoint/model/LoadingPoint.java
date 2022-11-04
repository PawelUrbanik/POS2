package pl.pawel.loadingPoint.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawel.operatingControlPoint.model.OperatingControlPoint;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
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
}
