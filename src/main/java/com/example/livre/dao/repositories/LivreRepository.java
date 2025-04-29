package com.example.livre.dao.repositories;

import com.example.livre.dao.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    boolean existsByTitreAndPublisher(String titre, String publisher);
    List<Livre> findByPublisherAndPrix(String publisher, double prix); // Ajoutez cette ligne
    List<Livre> findByTitre(String titre);
}