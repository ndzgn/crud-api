package learn.spring_boot.crud.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import learn.spring_boot.crud.validator.ValidPrice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.UrlResource;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductDTO {

    @NotBlank(message = "Le nom de la marque ne peut etre pas vide ou null")
    private String brand;


    @Positive(message = "La masse est invalide, veuillez entrer une valeur positive")
    private double mass;

    @ValidPrice(message = "Prix invalide")
    private BigDecimal price;

    private String file_url;
}
