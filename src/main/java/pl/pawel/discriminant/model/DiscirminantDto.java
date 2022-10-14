package pl.pawel.discriminant.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiscirminantDto {

    private Long id;
    private String shortcut;
    private String description;
}
