package example.hospital.controller;

import example.hospital.model.dto.PatientDto;
import example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public int save(@RequestBody PatientDto patientdto) {
        System.out.println("PatientController.save");
        System.out.println("patientdto = " + patientdto);
        return patientService.save(patientdto);
    }

    @GetMapping
    public List<PatientDto> findAll(){
        return patientService.findAll();
    }

    @GetMapping("/view")
    public PatientDto findById(@RequestParam("patientid") int patientid){
        return patientService.find(patientid);
    }

    @PutMapping
    public int update(@RequestBody PatientDto patientDto) {
        return patientService.update(patientDto);
    }
    @DeleteMapping
    public int delete(@RequestParam("patientid") int patientid) {
        return patientService.delete(patientid);
    }
}
