package springproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "staffs")
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private int staffId;

	@Column(name = "first_name")
	@NotNull
	@NotBlank
	private String firstName;

	@Column(name = "last_name")
	@NotNull
	@NotBlank
	private String lastName;

	@Column(name = "email")
	@NotNull
	@NotBlank
	@Email
	private String email;

	@Column(name = "password")
	@NotNull
	@NotBlank
	private String password;
}
