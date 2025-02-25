package example.hospital.model.dto;

import lombok.*;

@Getter @Setter @ToString @Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private int doctorid;
    private String name;
    private String specialty;
    private String phone;
    private String createdat;

}
