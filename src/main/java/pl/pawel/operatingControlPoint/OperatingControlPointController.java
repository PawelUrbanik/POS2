package pl.pawel.operatingControlPoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pawel.operatingControlPoint.model.OperatingControlPointFormDto;
import pl.pawel.operatingControlPoint.model.OperatingControlPointRowDto;
import pl.pawel.operatingControlPoint.model.OperatingControlPointSearchCriteria;
import pl.pawel.operatingControlPoint.service.OperatingControlPointService;

import jakarta.validation.Valid;
import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/points")
@CrossOrigin("http://localhost:4200/")
public class OperatingControlPointController {


    private final OperatingControlPointService service;
    @GetMapping()
    public Page<OperatingControlPointRowDto> getPageCriteria(Pageable pageable, OperatingControlPointSearchCriteria criteria) {
        log.debug("opertaing control point get page started");
        final Page<OperatingControlPointRowDto> page = service.getPage(pageable, criteria);
        log.debug("operating control point finished.");
        return page;
    }

    @GetMapping("/{id}")
    public OperatingControlPointFormDto getOne(@PathVariable("id") Long id) {
        log.debug("opertaing control point get one started");
        final OperatingControlPointFormDto found = service.getOne(id);
        log.debug("operating control point get one finished.");
        return found;
    }

    @PostMapping
    public ResponseEntity<?> createOperatingControlPoint(@RequestBody @Valid OperatingControlPointFormDto dto) {
        try {
            final OperatingControlPointFormDto saved = service.createNewOperatingControlPoint(dto);
            return ResponseEntity.created(URI.create("/points/"+saved.getId())).build();
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOperatingControlPoint(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOpertaingControlPoint(@PathVariable Long id, @RequestBody @Valid OperatingControlPointFormDto dto) {
        try {
            final OperatingControlPointFormDto updated = service.updateOperatingControlPoint(dto);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.notFound().build();
        }
    }

}
