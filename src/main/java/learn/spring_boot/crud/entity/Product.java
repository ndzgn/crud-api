package learn.spring_boot.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "Brand can not be null or blank")
    private String brand;

    @NotBlank(message = "Price can not be null or blank")
    @PositiveOrZero(message = "Price can not be negative")
    @Min(value = 7500, message = "The min price is 7500")
    private BigDecimal price;

    @NotBlank(message = "Mass can not be null or blank")
    @Positive
    private double mass;
}
