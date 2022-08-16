package springproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resumes")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "schools" })

public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private int resumeId;

    @Column(name = "description")
    @NotNull
    @NotBlank
    private String description;

    @Column(name = "languages")
    @NotNull
    @NotBlank
    private String languages;

    @Column(name = "photo_url")
    @NotNull
    @NotBlank
    private String photoUrl;

    @Column(name = "git_hub_account")
    private String gitHubAccount;

    @Column(name = "linked_in_account")
    private String linkedInAccount;

    @OneToMany(mappedBy = "resume")
    private List<School> schools;

    @OneToMany(mappedBy = "resume")
    private List<WorkExperience> workExperiences;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
