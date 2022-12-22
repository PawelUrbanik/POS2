package pl.pawel.discriminant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawel.discriminant.model.Discriminant;

@Repository
public interface DiscriminantRrepoSQL extends DisciminantRepository, JpaRepository<Discriminant, Long> {

    boolean existsByShortcut(String shortcut);
}
