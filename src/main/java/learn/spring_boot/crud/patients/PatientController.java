package learn.spring_boot.crud.patients;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/patient")
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class PatientController {

    private PatientService patientService;

    @PostMapping
    public ResponseEntity savePatient(@RequestBody PatientDTO dto)
    {
        Patient patient = patientService.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }

    @GetMapping
    public ResponseEntity getAllPatient()
    {
        List<Patient> patientList = patientService.findAllPatients();
        return ResponseEntity.ok(patientList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPatientBy(@PathVariable int id) throws Exception
    {
        Patient patient = patientService.findPatientById(id);
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable int id)
    {
        return ResponseEntity.ok("Patient supprime");
    }
}
