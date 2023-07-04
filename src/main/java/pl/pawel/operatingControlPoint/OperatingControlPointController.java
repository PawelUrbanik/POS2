package pl.pawel.operatingControlPoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pawel.operatingControlPoint.model.OperatingControlPointFormDto;
import pl.pawel.operatingControlPoint.model.OperatingControlPointRowDto;
import pl.pawel.operatingControlPoint.service.OperatingControlPointService;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/points")
@CrossOrigin("http://localhost:4200/")
public class OperatingControlPointController {


    private final OperatingControlPointService service;
    @GetMapping()
    public Page<OperatingControlPointRowDto> getPage(Pageable pageable) {
        log.debug("opertaing control point get page started");
        final Page<OperatingControlPointRowDto> page = service.getPage(pageable);
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

//    @PostMapping
//    public ResponseEntity<?> createOperatingContolPoint(@RequestBody @Valid )

}
