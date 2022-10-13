package pl.pawel.discriminant.model;

public class DiscirminantDto {

    private Long id;
    private String shortcut;
    private String description;

    public DiscirminantDto(String shortcut, String description) {
        this.shortcut = shortcut;
        this.description = description;
    }

    public DiscirminantDto() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
