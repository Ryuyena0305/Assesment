package example.hospital.controller;
import example.hospital.model.dto.DoctorDto;
import example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public int save(@RequestBody DoctorDto doctorDto) {
        System.out.println("DoctorController.save");
        System.out.println("doctorDto = " + doctorDto);
        return doctorService.save(doctorDto);
    }

    @GetMapping
    public List<DoctorDto> findAll() {
        return doctorService.findAll();
    }

    @GetMapping("view")
    public DoctorDto find(@RequestParam ("doctorid") int doctorid) {
        return doctorService.find(doctorid);
    }
    @PutMapping
    public int update(@RequestBody DoctorDto doctorDto) {
        return doctorService.update(doctorDto);
    }

    @DeleteMapping
    public int delete(@RequestParam ("doctorid") int doctorid) {
        return doctorService.delete(doctorid);
    }


}
