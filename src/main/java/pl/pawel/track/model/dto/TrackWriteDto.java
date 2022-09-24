package pl.pawel.track.model.dto;

public class TrackWriteDto {

    private Integer trackNumber;
    private Double axisKm;

    private Long EdgeId;

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Double getAxisKm() {
        return axisKm;
    }

    public void setAxisKm(Double axisKm) {
        this.axisKm = axisKm;
    }

    public Long getEdgeId() {
        return EdgeId;
    }

    public void setEdgeId(Long edgeId) {
        EdgeId = edgeId;
    }
}
