package pl.pawel.edge.model.DTO;

import pl.pawel.platform.model.Platform;

public class EdgePlatformReadModel {

    private String platformNumber;
    private Double height;
    private Double length;
    private boolean requestStop;
    private String  pointName;

    public EdgePlatformReadModel(Platform platform) {
            this.platformNumber = String.valueOf(platform.getPlatformNumber());
            this.height = platform.getHeight();
            this.length = platform.getLength();
            this.requestStop = platform.isRequestStop();
            this.pointName= platform.getOperatingControlPoint().getPointName();
    }

    public String getPlatformNumber() {
        return platformNumber;
    }

    public void setPlatformNumber(String platformNumber) {
        this.platformNumber = platformNumber;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public boolean isRequestStop() {
        return requestStop;
    }

    public void setRequestStop(boolean requestStop) {
        this.requestStop = requestStop;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }
}
