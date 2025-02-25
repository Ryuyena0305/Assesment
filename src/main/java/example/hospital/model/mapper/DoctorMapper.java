package example.hospital.model.mapper;

import example.hospital.model.dto.DoctorDto;
import example.hospital.service.DoctorService;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface DoctorMapper {

    @Insert("insert into doctor (name, specialty, phone) values (#{name}, #{specialty}, #{phone})")
    public int save(DoctorDto doctorDto);

    @Select("select * from doctor")
    public List<DoctorDto> findAll() ;

    @Select("select * from doctor where doctorid = #{doctorid}")
    public DoctorDto find( int doctorid);

    @Update("update doctor set name=#{name}, specialty = #{specialty}, phone= #{phone}")
    public int update( DoctorDto doctorDto);

    @Delete("delete from doctor where doctorid = #{doctorid}")
    public int delete( int doctorid);
}
