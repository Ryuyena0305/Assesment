package example.hospital.model.mapper;

import example.hospital.model.dto.PatientDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PatientMapper {

    @Insert("insert into patient(name, birthdate,phone,address,createdat) values(#{name}, #{birthdate}, #{phone}, #{address}, now())")
    public int save(PatientDto patientdto);

    @Select("select * from patient ")
    List<PatientDto> findAll();

    @Select("select * from patient where patientid = #{patientid}")
    PatientDto find(int patientId);

    @Update("update patient set name = #{name}, birthdate = #{birthdate}, phone = #{phone}, address = #{address} where patientid = #{patientid} ")
    int update(PatientDto patientDto);

    @Delete("delete from patient where patientid = #{patientid}")
    int delete(int patientId);
}
