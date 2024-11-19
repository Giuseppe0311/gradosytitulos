CREATE TABLE IF NOT EXISTS degrees (
                                       id BIGSERIAL PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
                                       status BOOLEAN DEFAULT TRUE NOT NULL
);

CREATE TABLE IF NOT EXISTS programs (
                                        id BIGSERIAL PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
                                        description TEXT,
                                        duration INTEGER,
                                        degree_id BIGINT NOT NULL,
                                        status BOOLEAN DEFAULT TRUE NOT NULL,
                                        CONSTRAINT fk_degree FOREIGN KEY (degree_id) REFERENCES degrees (id)
);

CREATE TABLE IF NOT EXISTS students (
                                        id BIGSERIAL PRIMARY KEY,
                                        document_number VARCHAR(50) NOT NULL,
                                        name VARCHAR(255) NOT NULL,
                                        paternal_surname VARCHAR(255) NOT NULL,
                                        maternal_surname VARCHAR(255),
                                        email VARCHAR(255) NOT NULL,
                                        phone VARCHAR(50),
                                        grade_id BIGINT,
                                        photo TEXT,
                                        status BOOLEAN DEFAULT TRUE NOT NULL
);

CREATE TABLE IF NOT EXISTS inscriptions (
                                            id BIGSERIAL PRIMARY KEY,
                                            student_id BIGINT NOT NULL,
                                            program_id BIGINT NOT NULL,
                                            inscription_date DATE NOT NULL,
                                            inscription_status SMALLINT NOT NULL,  -- Cambiado a SMALLINT para el enum
                                            status BOOLEAN DEFAULT TRUE NOT NULL,
                                            CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students (id),
                                            CONSTRAINT fk_program FOREIGN KEY (program_id) REFERENCES programs (id)
);
