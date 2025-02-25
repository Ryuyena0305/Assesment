package example.hospital.service;

import example.hospital.model.dto.PatientDto;
import example.hospital.model.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientMapper patientMapper;


    public int save(PatientDto patientdto) {
        System.out.println("PatientController.save");
        System.out.println("patientdto = " + patientdto);
        return patientMapper.save(patientdto);
    }


    public List<PatientDto> findAll(){
        return patientMapper.findAll();
    }


    public PatientDto find( int patientid){
        return patientMapper.find(patientid);
    }


    public int update(PatientDto patientDto) {
        return patientMapper.update(patientDto);
    }

    public int delete( int patientid) {
        return patientMapper.delete(patientid);
    }


}
