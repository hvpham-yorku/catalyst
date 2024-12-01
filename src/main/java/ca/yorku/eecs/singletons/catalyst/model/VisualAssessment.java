package ca.yorku.eecs.singletons.catalyst.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "visual_assessments")
public class VisualAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Optometrist doctor;

    @NotNull(message = "Assessment date is required and cannot be empty.")
    @Column(name = "assessment_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate assessmentDate;

    @Column(name = "visual_acuity_left")
    private String visualAcuityLeft;

    @Column(name = "visual_acuity_right")
    private String visualAcuityRight;

    @Column(name = "refraction_left")
    private String refractionLeft;

    @Column(name = "refraction_right")
    private String refractionRight;

    @Column(name = "color_vision")
    private String colorVision;

    @Column(name = "visual_field")
    private String visualField;

    @Column(name = "pupillary_response")
    private String pupillaryResponse;

    @Column(name = "intraocular_pressure_left")
    private Double intraocularPressureLeft;

    @Column(name = "intraocular_pressure_right")
    private Double intraocularPressureRight;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
