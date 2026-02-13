package learn.spring_boot.crud.patients;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class PatientService {
    private PatientRepository patientRepository;
    private PatientMapper patientMapper;
    //CREATE PATIENT
    public Patient add(PatientDTO dto)
    {
        log.debug("Enregistrement du patient {}", dto.getNom());
        return  patientRepository.save(patientMapper.toEntity(dto));
    }

    //GET ALL PATIENTS
    public List<Patient> findAllPatients()
    {
        log.debug("Affichage de tous les patients");
        return patientRepository.findAll();
    }

    //GET PATIENT BY ID
    public Patient findPatientById(int id) throws Exception
    {
        return patientRepository.findById(id).orElseThrow(()-> new Exception("Patient not found"));
    }

    //DELETE PATIENT
    public void delete(int id)
    {
        log.debug("Suppression du patient {}", id);
        patientRepository.deleteById(id);
    }
}
