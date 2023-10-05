package pl.pawel.operatingControlPoint.model;

import lombok.Data;
import pl.pawel.discriminant.model.DiscirminantDto;
import pl.pawel.platform.model.PlatformSelectOptionDto;
import pl.pawel.railwayDepartment.model.RailwayDepartmentDto;

import java.util.List;
@Data
public class OperatingControlPointFormDto {
    private Long id;
    private String pointName;
    private Boolean loadingPoint;
    private Boolean otherManager;
//    private List<PlatformSelectOptionDto> platforms;
    private DiscirminantDto discriminant;
    private RailwayDepartmentDto railwayDepartment;
    private List<LinesAxisKm> lines;
}
