package example.hospital.model.mapper;

import example.hospital.model.dto.ResvDto;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ResvMapper {


    @Insert("insert into appointment (patientid, doctorid, appointmentdate, appointmenttime) values (#{patientid}, #{doctorid}, #{appointmentdate}, #{appointmenttime})")
    public int save(ResvDto resvDto);

    @Select("select * from appointment")
    public List<ResvDto> findAll();


    @Select("select * from appointment where appointmentdate = #{appointmentdate}")
    public List<ResvDto> findbydate( String appointmentdate);

    @Select("select * from appointment inner join doctor on appointment.doctorid=doctor.doctorid where patientid = #{patientid}")
    public List<ResvDto> findbypatient( int patientid);

    @Select("select * from appointment inner join patient on appointment.patientid = patient.patientid where doctorid = #{doctorid}")
    public List<ResvDto> findbydoctor( int doctorid);

    @Update("update appointment set  status = #{status} where appointmentid = #{appointmentid}  ")
    int statusupdate( ResvDto resvDto);


    @Update("update appointment set  doctorid = #{doctorid}, appointmentdate = #{appointmentdate}, appointmenttime = #{appointmenttime} ,status=#{status} where appointmentid = #{appointmentid}  ")
    public int update( ResvDto resvDto);

    @Delete("delete from appointment where appointmentid = #{appointmentid}")
    public int delete ( int appointmentid);
}
