package com.example.livre.service;

import com.example.livre.dao.entities.Livre;
import com.example.livre.dao.repositories.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivresManager implements LivresService {

    private final LivreRepository livreRepository;

    @Autowired
    public LivresManager(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @Override
    public Livre ajouterLivre(Livre livre) {
        if (livre == null) {
            throw new IllegalArgumentException("Le livre ne peut pas être null");
        }

        if (livreRepository.existsByTitreAndPublisher(livre.getTitre(), livre.getPublisher())) {
            throw new IllegalStateException("Un livre avec ce titre et ce publisher existe déjà");
        }


        return livreRepository.save(livre);
    }

    @Override
    public List<Livre> getLivresByPublisherAndPrix(String publisher, double prix) {
        if (publisher == null || publisher.isBlank()) {
            throw new IllegalArgumentException("Le publisher ne peut pas être vide");
        }
        return livreRepository.findByPublisherAndPrix(publisher, prix);
    }

    @Override
    public List<Livre> getLivresByTitre(String titre) {
        if (titre == null || titre.isBlank()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide");
        }
        return livreRepository.findByTitre(titre);
    }

    @Override
    public void supprimerLivre(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID invalide");
        }
        if (!livreRepository.existsById(id)) {
            throw new IllegalStateException("Livre non trouvé avec l'ID: " + id);
        }
        livreRepository.deleteById(id);
    }
}