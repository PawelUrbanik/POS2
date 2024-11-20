package pl.pawel.platform;

import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pawel.platform.model.PlatformSelectOptionDto;
import pl.pawel.platform.model.PlatformTabTableRowDto;
import pl.pawel.platform.service.PlatformService;

import java.util.List;

@RestController
@RequestMapping("/platforms")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("http://localhost:4200/")
public class PlatformController {

    private final PlatformService platformService;

    @GetMapping("/{pointId}")
    public ResponseEntity<List<PlatformSelectOptionDto>> getPlatformsByOperatingControlPointId(@PathVariable Long pointId) {
        log.debug("Get Platforms by control point Id: " + pointId);

        final List<PlatformSelectOptionDto> platforms = platformService.getAllByOperatingControlPoint(pointId);
        log.debug("Found platforms: " + platforms.size());
        return ResponseEntity.ok(platforms);
    }

    @GetMapping("/getList/{pointId}")
    public ResponseEntity<List<PlatformTabTableRowDto>> getTabRowDto(@PathVariable Long pointId) {
        log.debug("Get Platforms for Platform tab by control point Id: " + pointId);

        final List<PlatformTabTableRowDto> platforms = platformService.getAllTabRowDtosByPointId(pointId);
        log.debug("Found platforms: " + platforms.size());
        return ResponseEntity.ok(platforms);

    }

}
