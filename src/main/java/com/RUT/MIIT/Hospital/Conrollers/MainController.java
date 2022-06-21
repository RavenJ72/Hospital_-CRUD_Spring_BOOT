package com.RUT.MIIT.Hospital.Conrollers;

import com.RUT.MIIT.Hospital.Patient;
import com.RUT.MIIT.Hospital.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class MainController {





    @Autowired
    private PatientRepository patientRepository;


    @GetMapping("/")
    public String home(Model model) {
        Iterable<Patient> hospitalList = patientRepository.findAll();
        model.addAttribute("title", "MIIT Hospital List");
        if (!hospitalList.iterator().hasNext()) {
            model.addAttribute("message", "List is empty!");
        }

        model.addAttribute("list", hospitalList);
        return "index";
    }

    @GetMapping("/addPatient")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("title", "List addition");
        return "addPatient";
    }


    @GetMapping("/patients/{code}")
    public String getPersonById(@PathVariable long code, Model model) {

        Patient x = patientRepository.findById(code).orElseThrow();
        model.addAttribute("patient", x);
        model.addAttribute("title", x.getName());
        return "personActions";
    }

    @PostMapping("/addPatient")
    public String addPerson(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("connectionStatus", "Failed!");
            return "addPatient";
        }

        patientRepository.save(patient);
        model.addAttribute("connectionStatus", "Success!");
        return "addPatient";
    }

    @GetMapping("/patients/editPatient/{code}")
    public String editPatientPage(Model model, @PathVariable Long code) {
        Patient x = patientRepository.findById(code).orElseThrow();
        model.addAttribute("patient", x);
        model.addAttribute("title", x.getName() + " edit profile");


        return "editPatient";
    }

    @PutMapping("/patients/editPatient/{code}")
    public String editPatient(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult, Model model, @PathVariable Long code) {



        if (bindingResult.hasErrors()) {
            model.addAttribute("connectionStatus", "Failed!");

            return "editPatient";
        }

        patient.setSelfCode(code);
        patientRepository.save(patient);

        model.addAttribute("connectionStatus", "Success!");

        return "editPatient";
    }

    @DeleteMapping("/patients/{code}/delete")
    public String delPatient(@PathVariable long code) {
        patientRepository.delete(patientRepository.findById(code).orElseThrow());
        return "redirect:/";
    }


}
