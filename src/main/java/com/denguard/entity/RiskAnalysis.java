package com.denguard.entity;

import com.denguard.entity.enums.RiskLevel;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "risk_analysis")
public class RiskAnalysis {

    @Id
    @Column(name = "risk_analysis_id")
    private UUID id;

    @Column(name = "risk_analysis_region", nullable = false, length = 150)
    private String region;

    @Enumerated(EnumType.STRING)
    @Column(name = "risk_analysis_risl_level", nullable = false, length = 20)
    private RiskLevel riskLevel;

    @Column(name = "risk_analysis_score", nullable = false)
    private Integer score;

    @Column(name = "risk_analysis_analyzed_at", nullable = false)
    private LocalDateTime analyzed_at;

    public RiskAnalysis() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDateTime getAnalyzed_at() {
        return analyzed_at;
    }

    public void setAnalyzed_at(LocalDateTime analyzed_at) {
        this.analyzed_at = analyzed_at;
    }
}
