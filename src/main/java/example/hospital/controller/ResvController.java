package example.hospital.controller;
import example.hospital.model.dto.ResvDto;
import example.hospital.service.ResvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resv")
public class ResvController {

    @Autowired
    private ResvService resvService;

    @PostMapping
    public int save(@RequestBody ResvDto resvDto){
        System.out.println("ResvController.save");
        System.out.println("resvDto = " + resvDto);
        return resvService.save(resvDto);
    }

    @GetMapping
    public List<ResvDto> findAll(){
        return resvService.findAll();
    }

    @GetMapping("/datebyview")
    public List<ResvDto> findbydate(@RequestParam("appointmentdate") String appointmentdate){
    return resvService.findbydate(appointmentdate);
    }
    @GetMapping("/patientbyview")
    public List<ResvDto> findbypatient(@RequestParam("patientid") int patientid){
        return resvService.findbypatient(patientid);
    }
    @GetMapping("/doctorbyview")
    public List<ResvDto> findbydoctor(@RequestParam("doctorid") int doctorid){
        return resvService.findbydoctor(doctorid);
    }

    @PutMapping("/status")
    public int statusupdate(@RequestBody ResvDto resvDto){
        return resvService.statusupdate(resvDto);
    }

    @PutMapping
    public int update(@RequestBody ResvDto resvDto){
        return resvService.update(resvDto);
    }

    @DeleteMapping
    public int delete (@RequestParam("appointmentid") int appointmentid){
    return resvService.delete(appointmentid);
    }
}
