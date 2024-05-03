package pl.pawel.discriminant.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Getter
@Setter
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
