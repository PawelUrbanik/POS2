drop table if exists OPERATING_CONTROL_POINT cascade;
CREATE TABLE operating_control_point
(
    id                    BIGINT NOT NULL,
    point_name            VARCHAR(255),
    loading_point         BOOLEAN,
    axis_km               DOUBLE,
    other_manager         BOOLEAN,
    discriminant_id       BIGINT,
    railway_department_id BIGINT,
    CONSTRAINT pk_operatingcontrolpoint PRIMARY KEY (id)
);
ALTER TABLE operating_control_point
    ADD CONSTRAINT FK_OPERATINGCONTROLPOINT_ON_DISCRIMINANT FOREIGN KEY (discriminant_id) REFERENCES discriminant (id);

ALTER TABLE operating_control_point
    ADD CONSTRAINT FK_OPERATINGCONTROLPOINT_ON_RAILWAYDEPARTMENT FOREIGN KEY (railway_department_id) REFERENCES railway_department (id);