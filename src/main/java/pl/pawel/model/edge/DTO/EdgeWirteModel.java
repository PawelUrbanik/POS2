package pl.pawel.model.edge.DTO;

import pl.pawel.model.edge.Edge;
import pl.pawel.model.platform.Platform;

public class EdgeWirteModel {

    private String egdeName;
    private Platform platform;

    public EdgeWirteModel(String egdeName, Platform platformId) {
        this.egdeName = egdeName;
        this.platform = platformId;
    }

    public String getEgdeName() {
        return egdeName;
    }

    public void setEgdeName(String egdeName) {
        this.egdeName = egdeName;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Edge toEdge(){
        return new Edge(this.egdeName, platform);
    }
}
