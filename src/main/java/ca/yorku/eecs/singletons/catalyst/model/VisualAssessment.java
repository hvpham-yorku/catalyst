package ca.yorku.eecs.singletons.catalyst.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "visual_assessments")
public class VisualAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Optometrist doctor;

    @Column(name = "assessment_date")
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
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
