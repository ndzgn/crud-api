package learn.spring_boot.crud.patients;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
    private int id;
    private String nom;
    private String prenom;
    private LocalDate date_naissance;
    private String sexe;
    private String telephone;
}
