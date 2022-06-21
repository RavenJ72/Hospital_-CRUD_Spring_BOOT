package com.RUT.MIIT.Hospital.Repositories;

import com.RUT.MIIT.Hospital.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient,Long> {

}
