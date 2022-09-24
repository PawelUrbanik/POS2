package pl.pawel.track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawel.track.model.Track;

@Repository
public interface TrackRepositorySQL extends TrackRepository, JpaRepository<Track, Long> {
}
