package com.example.livre.service;

import com.example.livre.dao.entities.Livre;
import java.util.List;

public interface LivresService {
    Livre ajouterLivre(Livre livre);
    List<Livre> getLivresByPublisherAndPrix(String publisher, double prix);
    List<Livre> getLivresByTitre(String titre);
    void supprimerLivre(Long id);
}