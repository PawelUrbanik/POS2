package pl.pawel.model.loadingPoint;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawel.model.operatingControlPoint.OperatingControlPoint;

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
