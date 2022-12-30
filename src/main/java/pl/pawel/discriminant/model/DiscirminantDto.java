package pl.pawel.discriminant.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
public class DiscirminantDto {

    private Long id;
    @NotNull
    @Size(min = 1, max = 4)
    private String shortcut;
    @NotNull
    @Size(min = 1, max = 255)
    private String description;
}
