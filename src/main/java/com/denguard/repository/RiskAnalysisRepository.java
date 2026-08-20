package com.denguard.repository;

import com.denguard.entity.RiskAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RiskAnalysisRepository extends JpaRepository<RiskAnalysis, UUID> {
}
