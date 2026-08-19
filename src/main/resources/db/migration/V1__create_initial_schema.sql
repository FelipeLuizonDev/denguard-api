CREATE TABLE users (
    user_id UUID PRIMARY KEY,

    user_name VARCHAR(120) NOT NULL,

    user_email VARCHAR(180) NOT NULL UNIQUE,

    user_password_hash VARCHAR(255) NOT NULL,

    user_role VARCHAR(20) NOT NULL,

    user_created_at TIMESTAMP NOT NULL,

    CONSTRAINT chk_users_role
        CHECK (
            user_role IN (
                'CITIZEN',
                'AGENT',
                'ADMIN'
            )
        )
);

CREATE TABLE reports (
    report_id UUID PRIMARY KEY,

    user_id UUID NOT NULL,

    report_description TEXT NOT NULL,

    report_image_url VARCHAR(500) NOT NULL,

    report_latitude DECIMAL(9, 6) NOT NULL,

    report_longitude DECIMAL(9, 6) NOT NULL,

    report_address VARCHAR(255),

    report_status VARCHAR(30) NOT NULL,

    report_priority VARCHAR(20) NOT NULL,

    report_created_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_reports_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id),

    CONSTRAINT chk_reports_status
        CHECK (
            report_status IN (
                'PENDING',
                'UNDER_ANALYSIS',
                'INSPECTION_SCHEDULED',
                'INSPECTED',
                'RESOLVED',
                'REJECTED'
            )
        ),

    CONSTRAINT chk_reports_priority
        CHECK (
            report_priority IN (
                'LOW',
                'MEDIUM',
                'HIGH'
            )
        )
);

CREATE TABLE inspections (
    inspection_id UUID PRIMARY KEY,

    report_id UUID NOT NULL,

    user_id UUID NOT NULL,

    inspection_scheduled_at TIMESTAMP NOT NULL,

    inspection_completed_at TIMESTAMP,

    inspection_result VARCHAR(100),

    inspection_observations TEXT,

    CONSTRAINT fk_inspections_report
        FOREIGN KEY (report_id)
        REFERENCES reports(report_id),

    CONSTRAINT fk_inspections_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
);

CREATE TABLE notifications (
    notification_id UUID PRIMARY KEY,

    user_id UUID NOT NULL,

    notification_title VARCHAR(150) NOT NULL,

    notification_message TEXT NOT NULL,

    notification_read BOOLEAN NOT NULL DEFAULT FALSE,

    notification_created_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_notifications_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
);

CREATE TABLE risk_analysis (
    risk_analysis_id UUID PRIMARY KEY,

    risk_analysis_region VARCHAR(150) NOT NULL,

    risk_analysis_risk_level VARCHAR(20) NOT NULL,

    risk_analysis_score INTEGER NOT NULL,

    risk_analysis_analyzed_at TIMESTAMP NOT NULL,

    CONSTRAINT chk_risk_analysis_level
        CHECK (
            risk_analysis_risk_level IN (
                'LOW',
                'MEDIUM',
                'HIGH'
            )
        ),

    CONSTRAINT chk_risk_analysis_score
        CHECK (
            risk_analysis_score >= 0
            AND risk_analysis_score <= 100
        )
);