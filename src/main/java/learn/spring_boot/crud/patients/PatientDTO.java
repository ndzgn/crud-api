package learn.spring_boot.crud.patients;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO {
    private String nom;
    private String prenom;
    private LocalDate date_naissance;
    private String sexe;
    private String telephone;
}
