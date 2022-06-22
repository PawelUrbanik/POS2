package pl.pawel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.pawel.model.track.Track;

@RepositoryRestResource
public interface TrackRepository extends JpaRepository<Track, Long> {
}
