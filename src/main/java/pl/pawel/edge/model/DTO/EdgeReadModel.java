package pl.pawel.edge.model.DTO;

import pl.pawel.edge.model.Edge;
import pl.pawel.track.model.Track;

import java.util.Set;

public class EdgeReadModel {

    private String edgeName;
    private Set<String> tracks;
    private EdgePlatformReadModel platform;


    public EdgeReadModel(Edge edge) {
        this.edgeName = edge.getEgdeName();
        edge.getTracks().stream()
                .map(Track::getTrackNumber)
                .forEach(trackName -> tracks.add(String.valueOf(trackName)));
        platform = new EdgePlatformReadModel(edge.getPlatform());
    }

    public String getEdgeName() {
        return edgeName;
    }

    public void setEdgeName(String edgeName) {
        this.edgeName = edgeName;
    }

    public Set<String> getTracks() {
        return tracks;
    }

    public void setTracks(Set<String> tracks) {
        this.tracks = tracks;
    }

    public EdgePlatformReadModel getPlatform() {
        return platform;
    }

    public void setPlatform(EdgePlatformReadModel platform) {
        this.platform = platform;
    }
}
