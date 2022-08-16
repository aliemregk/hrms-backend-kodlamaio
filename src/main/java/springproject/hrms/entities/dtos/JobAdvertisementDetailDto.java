package springproject.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDetailDto {
	private int id;
	private String jobDescription;
	private String employerCompany;
	private String jobTitleName;
}
