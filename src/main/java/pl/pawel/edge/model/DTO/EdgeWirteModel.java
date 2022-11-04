package pl.pawel.edge.model.DTO;

import pl.pawel.edge.model.Edge;
import pl.pawel.platform.model.Platform;

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
