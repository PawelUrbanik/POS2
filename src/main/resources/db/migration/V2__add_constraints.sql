alter table OPERATING_CONTROL_POINT add foreign key (LOADING_POINT_ID) references LOADING_POINT (ID);
alter table OPERATING_CONTROL_POINT add foreign key (LINE_ID) references LINE (ID);
alter table OPERATING_CONTROL_POINT add foreign key (RAILWAY_DEPARTMENT_ID) references RAILWAY_DEPARTMENT (ID);
alter table OPERATING_CONTROL_POINT add foreign key (DISCRIMINANT_ID) references DISCRIMINANT (ID);

alter table LOADING_POINT add foreign key (OPERATING_CONTROL_POINT_ID) references OPERATING_CONTROL_POINT (ID);

alter table PLATFORM add foreign key (OPERATING_CONTROL_POINT_ID) references OPERATING_CONTROL_POINT (ID);

alter table EDGE add foreign key (PLATFORM_ID) references PLATFORM (ID);

alter table TRACK add foreign key (EDGE_ID) references EDGE (ID);

