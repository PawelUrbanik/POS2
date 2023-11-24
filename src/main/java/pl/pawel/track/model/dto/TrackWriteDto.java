package pl.pawel.track.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrackWriteDto {

    private String trackNumber;
    private Double axisKm;
    private Long EdgeId;
}
