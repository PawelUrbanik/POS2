package pl.pawel.track.service;


import org.springframework.stereotype.Service;
import pl.pawel.edge.model.Edge;
import pl.pawel.edge.repository.EdgeRepository;
import pl.pawel.track.model.Track;
import pl.pawel.track.model.dto.TrackWriteDto;
import pl.pawel.track.repository.TrackRepository;

import jakarta.transaction.Transactional;

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
