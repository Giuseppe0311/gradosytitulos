ALTER TABLE degrees
    ADD COLUMN created TIMESTAMP WITH TIME ZONE,
    ADD COLUMN updated TIMESTAMP WITH TIME ZONE,
    ADD COLUMN created_by VARCHAR(255),
    ADD COLUMN updated_by VARCHAR(255);

-- Añadir columnas de auditoría a la tabla programs
ALTER TABLE programs
    ADD COLUMN created TIMESTAMP WITH TIME ZONE,
    ADD COLUMN updated TIMESTAMP WITH TIME ZONE,
    ADD COLUMN created_by VARCHAR(255),
    ADD COLUMN updated_by VARCHAR(255);

-- Añadir columnas de auditoría a la tabla students
ALTER TABLE students
    ADD COLUMN created TIMESTAMP WITH TIME ZONE,
    ADD COLUMN updated TIMESTAMP WITH TIME ZONE,
    ADD COLUMN created_by VARCHAR(255),
    ADD COLUMN updated_by VARCHAR(255);

-- Añadir columnas de auditoría a la tabla inscriptions
ALTER TABLE inscriptions
    ADD COLUMN created TIMESTAMP WITH TIME ZONE,
    ADD COLUMN updated TIMESTAMP WITH TIME ZONE,
    ADD COLUMN created_by VARCHAR(255),
    ADD COLUMN updated_by VARCHAR(255);
