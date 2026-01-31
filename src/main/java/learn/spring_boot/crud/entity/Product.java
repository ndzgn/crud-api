package learn.spring_boot.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import learn.spring_boot.crud.validator.ValidPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @NotBlank(message = "Le nom de la marque ne peut etre pas vide ou null")
    private String brand;


    @ValidPrice(message = "Prix invalide")
    private BigDecimal price;

    @NotBlank(message = "La masse ne peut pas etre vide ou null")
    @Positive(message = "La masse est invalide, veuillez entrer une valeur positive")
    private double mass;
}
