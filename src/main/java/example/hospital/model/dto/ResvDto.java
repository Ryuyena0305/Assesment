package example.hospital.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResvDto {
    private String appointmentid;
    private String patientid;
    private String doctorid;
    private String appointmentdate;
    private String appointmenttime;
    private String status;
    private String createdat;
}
