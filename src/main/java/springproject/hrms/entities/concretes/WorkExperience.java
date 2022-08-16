package springproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "work_experiences")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resume" })
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_experience_id")
    private int workExperienceId;

    @Column(name = "company_name")
    @NotNull
    @NotBlank
    private String companyName;

    @Column(name = "position")
    @NotNull
    @NotBlank
    private String position;

    @Column(name = "isWorking")
    @NotNull
    @NotBlank
    private boolean isWorking;

    @Column(name = "quitYear")
    @Nullable
    private int quitYear;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
