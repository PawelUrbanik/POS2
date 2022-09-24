package pl.pawel.track.service;


import org.springframework.stereotype.Service;
import pl.pawel.model.edge.Edge;
import pl.pawel.repository.EdgeRepository;
import pl.pawel.track.model.Track;
import pl.pawel.track.model.dto.TrackWriteDto;
import pl.pawel.track.repository.TrackRepository;

import javax.transaction.Transactional;

@Service
public class TrackService {


    TrackRepository trackRepository;
    EdgeRepository edgeRepository;

    public TrackService(TrackRepository trackRepository, EdgeRepository edgeRepository) {
        this.trackRepository = trackRepository;
        this.edgeRepository = edgeRepository;
    }

    @Transactional
    public void save(TrackWriteDto writeDto) {
        Track track = new Track();
        track.setTrackNumber(writeDto.getTrackNumber());
        track.setAxisKm(writeDto.getAxisKm());

        final Edge edge = edgeRepository.getById(writeDto.getEdgeId());
        track.setEdge(edge);
        trackRepository.save(track);
    }
}
