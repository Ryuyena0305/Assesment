package example.hospital.service;

import example.hospital.model.dto.ResvDto;
import example.hospital.model.mapper.ResvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ResvService {

    @Autowired
    private ResvMapper resvMapper;


    public int save(ResvDto resvDto){
        return resvMapper.save(resvDto);
    }


    public List<ResvDto> findAll(){
        return resvMapper.findAll();
    }



    public List<ResvDto> findbydate( String appointmentdate){
        return resvMapper.findbydate(appointmentdate);
    }

    public List<ResvDto> findbypatient( int patientid){
        return resvMapper.findbypatient(patientid);
    }

    public List<ResvDto> findbydoctor( int doctorid){
        return resvMapper.findbydoctor(doctorid);
    }

    public int statusupdate( ResvDto resvDto){
        return resvMapper.statusupdate(resvDto);
    }


    public int update( ResvDto resvDto){
        return resvMapper.update(resvDto);
    }


    public int delete ( int appointmentid){
        return resvMapper.delete(appointmentid);
    }
}
