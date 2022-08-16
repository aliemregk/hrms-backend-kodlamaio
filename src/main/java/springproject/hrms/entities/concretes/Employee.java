package springproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resume" })
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "first_name")
	@NotNull
	@NotBlank
	private String firstName;

	@Column(name = "last_name")
	@NotNull
	@NotBlank
	private String lastName;

	@Column(name = "national_identity")
	@NotNull
	@NotBlank
	private String nationalIdentity;

	@Column(name = "birth_year")
	@NotNull
	@NotBlank
	private int birthYear;

	@Column(name = "email")
	@NotNull
	@NotBlank
	@Email
	private String email;

	@Column(name = "password")
	@NotNull
	@NotBlank
	private String password;

	@Column(name = "is_confirmed")
	@NotNull
	@NotBlank
	private boolean isConfirmed;

	@OneToOne(mappedBy = "employee")
	private Resume resume;
}
