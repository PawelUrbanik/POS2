package pl.pawel.discriminant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.discriminant.model.DiscirminantDto;
import pl.pawel.discriminant.model.Discriminant;
import pl.pawel.discriminant.service.DiscriminantService;

import java.util.List;

@RestController()
@RequestMapping("/discriminants")
@CrossOrigin("http://localhost:4200/")
public class DiscriminantController {

    private DiscriminantService discriminantService;

    public DiscriminantController(DiscriminantService discriminantService) {
        this.discriminantService = discriminantService;
    }

    @GetMapping()
    public ResponseEntity<List<DiscirminantDto>> getAllDiscriminant() {
        final List<DiscirminantDto> allDiscriminants = discriminantService.getAllDiscriminants();
        return ResponseEntity.ok(allDiscriminants);
    }
}
