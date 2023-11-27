package br.com.cleilsonandrade.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "job")
@Table(name = "tb_job")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Schema(example = "Design vacancy")
  private String description;

  @Schema(example = "GYMPass")
  private String benefits;

  @Schema(example = "Senior")
  @NotBlank(message = "This field is mandatory")
  private String level;

  @ManyToOne()
  @JoinColumn(name = "company_id", insertable = false, updatable = false)
  private CompanyEntity companyEntity;
  @Column(name = "company_id", nullable = false)
  private UUID companyId;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
