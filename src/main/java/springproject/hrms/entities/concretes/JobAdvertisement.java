package springproject.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_advertisement_id")
	private int jobAdvertisementId;

	@Column(name = "description")
	@NotNull
	@NotBlank
	private String description;

	@Column(name = "city")
	@NotNull
	@NotBlank
	private String city;

	@Column(name = "salary")
	private double salary;

	@Column(name = "open_position_number")
	@NotNull
	@NotBlank
	private int openPositionNumber;

	@Column(name = "release_date")
	@NotNull
	@NotBlank
	@PastOrPresent
	private Date releaseDate;

	@Column(name = "last_apply")
	@NotNull
	@NotBlank
	@Future
	private Date lastApply;

	@Column(name = "is_active")
	@NotNull
	@NotBlank
	private boolean isActive;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;

}
