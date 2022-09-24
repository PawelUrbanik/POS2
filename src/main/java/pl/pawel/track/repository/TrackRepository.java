package pl.pawel.track.repository;

import pl.pawel.track.model.Track;

public interface TrackRepository {
    Track save(Track entity);
}
