package com.example.livre;

import com.example.livre.dao.entities.Livre;
import com.example.livre.service.LivresService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivreApplication implements CommandLineRunner {
    private final LivresService livresService;

    public LivreApplication(LivresService livresService) {
        this.livresService = livresService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LivreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Livre livre1 = new Livre();
        livre1.setTitre("Bt ");
        livre1.setPublisher("Ahmed");
        livre1.setPrix(89.50);
        livre1.setResume("Un livre de qualite ");
        livresService.ajouterLivre(livre1);

        Livre livre2 = new Livre();
        livre2.setTitre("Ant");
        livre2.setPublisher("khalid");
        livre2.setPrix(45.50);
        livre2.setResume("piece ");
        livresService.ajouterLivre(livre2);
    }
}