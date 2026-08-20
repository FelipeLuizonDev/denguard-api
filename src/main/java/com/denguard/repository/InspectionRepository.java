package com.denguard.repository;

import com.denguard.entity.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InspectionRepository extends JpaRepository<Inspection, UUID> {
}
