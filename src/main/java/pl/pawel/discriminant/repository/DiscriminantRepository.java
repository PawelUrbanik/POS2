package pl.pawel.discriminant.repository;

import pl.pawel.discriminant.model.Discriminant;

import java.util.List;

public interface DiscriminantRepository {

    List<Discriminant> findAll();

    Discriminant save(Discriminant discriminant);

    Discriminant getById(Long id);

    boolean existsByShortcut(String shortcut);

    void deleteById(Long id);

    boolean existsById(Long id);
}

