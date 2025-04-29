package com.example.livre.dao.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
    public class Livre {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_livre;
        private String titre;
        private String publisher;
        private double prix;
        private String resume;

      
    }



