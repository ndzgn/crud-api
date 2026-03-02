package learn.spring_boot.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import learn.spring_boot.crud.validator.ValidPrice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.UrlResource;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotBlank(message = "Le nom de la marque ne peut etre pas vide ou null")
    private String brand;


    @ValidPrice(message = "Prix invalide")
    private BigDecimal price;


    @Positive(message = "La masse est invalide, veuillez entrer une valeur positive")
    private double mass;

    private String file_url;
}
