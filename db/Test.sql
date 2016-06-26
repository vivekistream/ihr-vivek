SELECT * FROM EMPLOYEE;

SELECT * FROM  project;

INSERT INTO PROJECT VALUES (1,"IHR_PROJECT","IHR_PROJ", SYSDATE(), SYSDATE(), SYSDATE(), SYSDATE())
INSERT INTO project_task VALUES (1,"IHR_PROJECT_TASK1", SYSDATE(), SYSDATE(), SYSDATE(), SYSDATE(), 1)

SELECT * FROM project_task;

SELECT * FROM ihr.time_sheet;

SELECT * FROM ihr.time_sheet_task_as;

DELETE FROM ihr.time_sheet_task_as where task_id = 1;

DELETE FROM ihr.time_sheet where project_id = 1;

ALTER TABLE ihr.time_sheet CHANGE Approver_id Employee_id int(11);
ALTER TABLE ihr.time_sheet Add  Description VARCHAR(250);
ALTER TABLE ihr.time_sheet CHANGE Start_Date Time_sheet_date date;
ALTER TABLE ihr.time_sheet DROP Column End_Date;


SELECT * FROM time_sheet 
   WHERE month(Time_sheet_date) = 6 
         AND YEAR(Time_sheet_date) = 2016
         AND Employee_id = 124

UPDATE time_sheet SET Employee_id = 125 WHERE Time_sheet_id = '7'

