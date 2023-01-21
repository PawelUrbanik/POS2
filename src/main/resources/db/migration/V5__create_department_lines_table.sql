drop table if exists departments_lines cascade;
CREATE TABLE departments_lines
(
    department_id BIGINT NOT NULL,
    line_id       BIGINT NOT NULL
);
ALTER TABLE departments_lines ADD CONSTRAINT fk_deplin_on_line FOREIGN KEY (line_id) REFERENCES line (id);

ALTER TABLE departments_lines ADD CONSTRAINT fk_deplin_on_railway_department FOREIGN KEY (department_id) REFERENCES railway_department (id);