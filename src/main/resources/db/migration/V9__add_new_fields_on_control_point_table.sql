alter table OPERATING_CONTROL_POINT add column loading_point boolean;
alter table OPERATING_CONTROL_POINT add column other_manager boolean;
alter table OPERATING_CONTROL_POINT drop column LOADING_POINT_ID;
alter table OPERATING_CONTROL_POINT drop column LINE_ID;