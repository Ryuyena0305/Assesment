package example.hospital.service;

import example.hospital.model.dto.DoctorDto;
import example.hospital.model.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;



    public int save(DoctorDto doctorDto) {
        System.out.println("DoctorController.save");
        System.out.println("doctorDto = " + doctorDto);
        return doctorMapper.save(doctorDto);
    }

    public List<DoctorDto> findAll() {
        return doctorMapper.findAll();
    }

    public DoctorDto find( int doctorid) {
        return doctorMapper.find(doctorid);
    }
    public int update( DoctorDto doctorDto) {
        return doctorMapper.update(doctorDto);
    }


    public int delete( int doctorid) {
        return doctorMapper.delete(doctorid);
    }
}
