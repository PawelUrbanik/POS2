package pl.pawel.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.model.Edge;
import pl.pawel.repository.EdgeRepository;

import java.util.List;

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


}
