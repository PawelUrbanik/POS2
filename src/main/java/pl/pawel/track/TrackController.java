package pl.pawel.track;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.track.model.dto.TrackWriteDto;
import pl.pawel.track.service.TrackService;

import javax.validation.Valid;

@RestController(value = "/tracks")
public class TrackController {

    private TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping
    public ResponseEntity<?> createTrack(@RequestBody @Valid TrackWriteDto writeDto) {

        trackService.save(writeDto);

        return ResponseEntity.ok().build();
    }
}
