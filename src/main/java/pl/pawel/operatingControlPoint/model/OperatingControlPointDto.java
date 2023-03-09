package pl.pawel.operatingControlPoint.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pawel.discriminant.model.Discriminant;
import pl.pawel.platform.model.Platform;
import pl.pawel.railwayDepartment.model.RailwayDepartment;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class OperatingControlPointDto {

    private Long id;
    private String pointName;
    private Boolean loadingPoint;
    private Boolean otherManager;
    private Set<Platform> platforms;
    private Discriminant discriminant;
    private RailwayDepartment railwayDepartment;
    private Set<LinesAxisKm> lines;
}
