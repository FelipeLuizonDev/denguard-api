package com.denguard.entity;

import com.denguard.entity.enums.PriorityLevel;
import com.denguard.entity.enums.ReportStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @Column(name = "report_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "report_description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "report_image_url", nullable = false, length = 500)
    private String imageUrl;

    @Column(name = "report_latitude", precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(name = "report_longitude", precision = 9, scale = 6)
    private BigDecimal longitude;

    @Column(name = "report_address", length = 255)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_status", nullable = false, length = 30)
    private ReportStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_priority", nullable = false, length = 20)
    private PriorityLevel priority;

    @Column(name = "report_created_at", nullable = false)
    private LocalDateTime createdAt;

    public Report() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public PriorityLevel getPriority() {
        return priority;
    }

    public void setPriority(PriorityLevel priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
