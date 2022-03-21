package pl.pawel.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Edge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String egdeName;
    @OneToMany(mappedBy = "edge")
    private Set<Track> tracks;
    @ManyToOne
    private Platform platform;



}
