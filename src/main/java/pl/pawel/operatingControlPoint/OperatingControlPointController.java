package pl.pawel.operatingControlPoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.operatingControlPoint.model.OperatingControlPointRowDto;
import pl.pawel.operatingControlPoint.service.OperatingControlPointService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/points")
public class OperatingControlPointController {


    private final OperatingControlPointService service;
    @GetMapping()
    public Page<OperatingControlPointRowDto> getPage(Pageable pageable) {
        log.debug("opertaing control point get page started");
        final Page<OperatingControlPointRowDto> page = service.getPage(pageable);
        log.debug("operating control point finished.");
        return page;
    }

}
