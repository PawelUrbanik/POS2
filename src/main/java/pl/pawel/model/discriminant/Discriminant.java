package pl.pawel.model.discriminant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Discriminant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortcut;
    private String description;


    Discriminant(String description) {
        this.description = description;
    }

    public Discriminant() {
    }

    public String getShortcut() {
        return shortcut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Discriminant{" +
                "id=" + id +
                ", shortcut='" + shortcut + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
