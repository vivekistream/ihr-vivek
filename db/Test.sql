SELECT * FROM EMPLOYEE;

SELECT * FROM  project;

INSERT INTO PROJECT VALUES (1,"IHR_PROJECT","IHR_PROJ", SYSDATE(), SYSDATE(), SYSDATE(), SYSDATE())
INSERT INTO project_task VALUES (1,"IHR_PROJECT_TASK1", SYSDATE(), SYSDATE(), SYSDATE(), SYSDATE(), 1)

SELECT * FROM project_task;

SELECT * FROM ihr.time_sheet;

SELECT * FROM ihr.time_sheet_task_as;