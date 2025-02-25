package example.hospital.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private int patientid;
    private String name;
    private String birthdate;
    private String phone;
    private String address;
    private String createdat;

}
