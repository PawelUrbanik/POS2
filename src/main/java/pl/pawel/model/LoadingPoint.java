package pl.pawel.model;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;

@Entity
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
