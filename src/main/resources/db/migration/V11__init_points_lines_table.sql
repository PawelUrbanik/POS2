CREATE TABLE lines_points
(
    line_id  BIGINT NOT NULL,
    point_id BIGINT NOT NULL,
    CONSTRAINT pk_lines_points PRIMARY KEY (line_id, point_id)
);

ALTER TABLE lines_points
    ADD CONSTRAINT fk_linpoi_on_line FOREIGN KEY (line_id) REFERENCES line (id);

ALTER TABLE lines_points
    ADD CONSTRAINT fk_linpoi_on_operating_control_point FOREIGN KEY (point_id) REFERENCES operating_control_point (id);