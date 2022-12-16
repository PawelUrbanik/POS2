package pl.pawel.track.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrackWriteDto {

    private String trackNumber;
    private Double axisKm;
    private Long EdgeId;
}
