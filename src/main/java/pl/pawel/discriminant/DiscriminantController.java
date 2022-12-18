package pl.pawel.discriminant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pawel.discriminant.model.DiscirminantDto;
import pl.pawel.discriminant.service.DiscriminantService;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/discriminants")
@CrossOrigin("http://localhost:4200/")
public class DiscriminantController {

    private final DiscriminantService discriminantService;

    public DiscriminantController(DiscriminantService discriminantService) {
        this.discriminantService = discriminantService;
    }

    @GetMapping()
    public ResponseEntity<List<DiscirminantDto>> getAllDiscriminant() {
        final List<DiscirminantDto> allDiscriminants = discriminantService.getAllDiscriminants();
        return ResponseEntity.ok(allDiscriminants);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDiscriminant(@PathVariable("id") Long id) {

        System.out.println("id");
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDiscrimiant(@PathVariable Long id, @RequestBody @Valid DiscirminantDto dto) {

        try {
            final DiscirminantDto discirminantDto = discriminantService.updateDiscriminant(dto);
            return ResponseEntity.ok(discirminantDto);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.notFound().build();
        }

    }
}
