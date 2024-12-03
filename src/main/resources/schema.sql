CREATE TABLE patients
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    birth_date   VARCHAR(255),
    gender       VARCHAR(255),
    email        VARCHAR(255),
    phone_number VARCHAR(12),
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE optometrists
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name     VARCHAR(255) NOT NULL,
    last_name      VARCHAR(255) NOT NULL,
    specialization VARCHAR(255),
    phone_number   VARCHAR(12),
    email          VARCHAR(255),
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE visual_assessments
(
    id                         BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_id                 BIGINT NOT NULL,
    doctor_id                  BIGINT NOT NULL,
    assessment_date            DATE,
    visual_acuity_left         VARCHAR(255),
    visual_acuity_right        VARCHAR(255),
    refraction_left            VARCHAR(255),
    refraction_right           VARCHAR(255),
    color_vision               VARCHAR(255),
    visual_field               VARCHAR(255),
    pupillary_response         VARCHAR(255),
    intraocular_pressure_left  DECIMAL(10, 2),
    intraocular_pressure_right DECIMAL(10, 2),
    notes                      TEXT,
    created_at                 TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at                 TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES patients (id),
    FOREIGN KEY (doctor_id) REFERENCES optometrists (id)
);

CREATE TABLE users
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    email    VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE roles
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE users_roles
(
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE
);
