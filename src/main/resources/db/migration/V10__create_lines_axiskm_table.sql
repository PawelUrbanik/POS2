DROP TABLE IF EXISTS lines_axis_km;
CREATE TABLE lines_axis_km
(
    line_id                    BIGINT NOT NULL,
    axis_km                    DOUBLE,
    operating_control_point_id BIGINT NOT NULL,
    CONSTRAINT pk_linesaxiskm PRIMARY KEY (line_id, operating_control_point_id)
);

ALTER TABLE lines_axis_km
    ADD CONSTRAINT FK_LINESAXISKM_ON_LINE FOREIGN KEY (line_id) REFERENCES line (id);

ALTER TABLE lines_axis_km
    ADD CONSTRAINT FK_LINESAXISKM_ON_OPERATINGCONTROLPOINT FOREIGN KEY (operating_control_point_id) REFERENCES operating_control_point (id);