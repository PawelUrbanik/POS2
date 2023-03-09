package pl.pawel.operatingControlPoint.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OperatingControlPointRowDto {

    private Long id;
    private String pointName;
    private Boolean loadingPoint;
    private Boolean otherManager;
    private Integer numberOfPlatforms;
    private String discriminant;
    private String railwayDepartment;

}
