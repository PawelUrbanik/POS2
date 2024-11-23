package pl.pawel.platform.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlatformTabTableRowDto {

    private Long id;
    private String platformNumber;
    private Double height;
    private Double length;
    private boolean requestStop;
    private Integer numberOfEdges;

}
