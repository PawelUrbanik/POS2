package pl.pawel.platform.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pawel.edge.model.Edge;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
public class PlatformSelectOptionDto {

    private Long id;
    private String platformNumber;
    private Double height;
    private Double length;
    private boolean requestStop;
    private Set<Edge> edges;
}
