package pl.pawel.platform;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pawel.platform.model.PlatformDto;
import pl.pawel.platform.model.PlatformSelectOptionDto;
import pl.pawel.platform.model.PlatformTabTableRowDto;
import pl.pawel.platform.model.SavePlatformDto;
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

    @GetMapping("/get/{platformId}")
    public ResponseEntity<?> getPlatformById(@PathVariable Long platformId) {
        log.debug("Get Platform by id: " + platformId);
        final PlatformDto dto = platformService.getPlatform(platformId);
        log.debug("Found platform: " + dto);

        return ResponseEntity.ok(dto);
    }

    @PutMapping("")
    public ResponseEntity<PlatformDto> updatePlatform(@RequestBody PlatformDto platformDto) {
        log.debug("Update Platform:  " + platformDto);
        final PlatformDto dto = platformService.updatePlatform(platformDto);
        log.debug("Updated platform: " + dto);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/add/{pointId}")
    public ResponseEntity<PlatformDto> savePlatform(
            @PathVariable Long pointId,
            @RequestBody SavePlatformDto platformDto) {
        log.debug("Save Platform:  " + platformDto);
        PlatformDto saved = platformService.savePlatform(platformDto, pointId);
        log.debug("Saved platform: " + platformDto);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{platformId}")
    public ResponseEntity<?> deletePlatform(@PathVariable Long platformId) {
        log.debug("Delete Platform:  " + platformId);
        try {
            platformService.deletePlatform(platformId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

}
