package learn.spring_boot.crud.patients;

import learn.spring_boot.crud.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PatientMapper implements Mapper<Patient,PatientDTO> {
    /**
     * Map DTO to his Entity
     *
     * @param dto the DTO
     * @return E entity
     */
    @Override
    public Patient toEntity(PatientDTO dto) {
        return Patient.builder()
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .sexe(dto.getSexe())
                .date_naissance(dto.getDate_naissance())
                .telephone(dto.getTelephone())
                .build();
    }

    /**
     * Map Entity to his DTO
     *
     * @param patient the Entity
     * @return D dto
     */
    @Override
    public PatientDTO toDTO(Patient patient) {
        return PatientDTO.builder()
                .nom(patient.getNom())
                .prenom(patient.getPrenom())
                .sexe(patient.getSexe())
                .telephone(patient.getTelephone())
                .date_naissance(patient.getDate_naissance())
                .build();
    }
}
