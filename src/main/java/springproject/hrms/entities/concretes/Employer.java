package springproject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisements" })
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_id")
	private int employerId;

	@Column(name = "company_name")
	@NotNull
	@NotBlank
	private String companyName;

	@Column(name = "web_page")
	@NotNull
	@NotBlank
	private String webPage;

	@Column(name = "email")
	@NotNull
	@NotBlank
	@Email
	private String email;

	@Column(name = "phone")
	@NotNull
	@NotBlank
	private String phone;

	@Column(name = "password")
	@NotNull
	@NotBlank
	private String password;

	@Column(name = "is_confirmed")
	@NotNull
	@NotBlank
	private boolean isConfirmed;

	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;

}
