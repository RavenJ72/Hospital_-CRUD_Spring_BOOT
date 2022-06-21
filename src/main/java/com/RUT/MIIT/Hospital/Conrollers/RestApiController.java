package com.RUT.MIIT.Hospital.Conrollers;


import com.RUT.MIIT.Hospital.Patient;
import com.RUT.MIIT.Hospital.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/rest/")
public class RestApiController {

    @Autowired
    private PatientRepository patientRepository;


    @GetMapping("/patients")
    public Iterable<Patient> getAll() {

        return patientRepository.findAll();
    }

    @GetMapping("/patients/{code}")
    public Optional<Patient> editPatientPage(@PathVariable Long code) {
        Optional<Patient> x  = patientRepository.findById(code);
        if(x.isPresent()){
            return x;
        }else{
            return Optional.empty();
        }
    }

    @PostMapping("/addPatient")
    public Patient addPerson(@RequestBody Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    @PutMapping("/editPatient/{code}")
    public Patient editPatient(@RequestBody Patient patient,@PathVariable Long code) {

        patient.setSelfCode(code);
        patientRepository.save(patient);
        return patient;

    }

    @DeleteMapping("/patients/{code}/delete")
    public void delPatient(@PathVariable long code) {
        patientRepository.delete(patientRepository.findById(code).orElseThrow());
    }

}
