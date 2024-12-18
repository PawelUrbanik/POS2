package pl.pawel.edge.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pawel.edge.model.Edge;
import pl.pawel.edge.repository.EdgeRepository;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EdgeController {


    private final Logger logger = LoggerFactory.getLogger(EdgeController.class);
    private final EdgeRepository repository;

    public EdgeController(EdgeRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all with no params
     * @return
     */
    @GetMapping(value = "/edges", params = {"!sort", "!page", "!size"})
    public ResponseEntity<List<Edge>> getAllEdges(){
        logger.info("REQUES GET ALL EDGES without params");
        return ResponseEntity.ok(repository.findAll());
    }

    /**
     * Get all edges. Request with pageable object
     * @param pageable
     * @return
     */
    @GetMapping("/edges")
    public ResponseEntity<List<Edge>> getAllEdges(Pageable pageable)
    {
        logger.info("REQUES GET ALL EDGES with params: \n" +
                "page: "+ pageable.getPageNumber()+ "\n" +
                "page size: "+ pageable.getPageSize()+ "\n"+
                "sort: " + pageable.getSort()
        );
        return new ResponseEntity<>(repository.findAll(pageable).getContent(), HttpStatus.OK);
    }

    /**
     * Get one edge by id parameter
     * @param id
     * @return found edge
     */
    @GetMapping("/edge/{id}")
    public ResponseEntity<Edge> getEdgeById(@PathVariable Long id){
        logger.info("REQUES GET ONE EDGE by id: "+ id);

        Optional<Edge> edge = repository.findById(id);
        return edge.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Save edge method
     * @param edge param from request
     * @return badRequest(400) if not saved or created(201) + created object
     */
    @PostMapping(value = "/edges")
    public ResponseEntity<?> saveEdge(@RequestBody @Valid Edge edge)
    {
        //TODO Add field constraints to Edge entity to valid properly
        Edge saved = repository.save(edge);
        return (saved == null)? ResponseEntity.badRequest().build() : new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /**
     * Update edsge request
     * @param id id of the object to update
     * @param toUpdate object to update
     * @return if not exist notFound(404), if not the dame ids badRequest(400), if updated noContent(204)
     */
    @PutMapping("/edge/{id}")
    public ResponseEntity<?> updateEdge(@RequestParam Long id, @Valid Edge toUpdate)
    {

        if (!repository.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }

//        if (toUpdate.getId()!= 0 && !id.equals(toUpdate.getId()))
//        {
//            return ResponseEntity.badRequest().build();
//        }

        repository.findById(id).ifPresent(edge -> {edge.updateFrom(toUpdate);});
        logger.info("Update edge: id:"+toUpdate.getId()+", name: "+ toUpdate.getEgdeName());
        return ResponseEntity.noContent().build();
    }




}
