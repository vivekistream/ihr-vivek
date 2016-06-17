package com.istream.ihr.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.istream.ihr.orm.Employee;
import com.istream.ihr.orm.Project;
import com.istream.ihr.orm.TimeSheet;
import com.istream.ihr.orm.TimeSheetTaskAs;
import com.istream.ihr.service.TimeSheetService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:E:\\GIT-Backup\\GIT-Workspace\\Istream\\integrate\\iHR\\WebContent\\WEB-INF\\applicationContext.xml" })
public class TimesheetTest {

	@Autowired
	TimeSheetService timesheetService;

	@Test
	public void lookupTx() {
		
		 Integer timeSheetId = 1;
		 Employee employee = new Employee();
		 employee.setEmployeeId(124);
		 Project project = new Project();
		 project.setProjectId(1);
		 Date startDate = new Date();
		 Date endDate = new Date();
		 int billedHours = 80;
		 Integer nonBilledHours = 20;
		 String note = "note";
		 String status = "NA";
		 Date creationTs = new Date();
		 Date lastUpdateTs = new Date();
		 Set<TimeSheetTaskAs> timeSheetTaskAses = new HashSet<TimeSheetTaskAs>(0);
		 TimeSheetTaskAs timeSheetTaskAs = new TimeSheetTaskAs();
		 timeSheetTaskAses.add(timeSheetTaskAs);
		 
		
		TimeSheet timeSheet = new TimeSheet(employee, project, startDate, endDate, billedHours, nonBilledHours, note, status, 
				creationTs, lastUpdateTs, timeSheetTaskAses);
		timeSheetTaskAs.setProjectTaskId(1);
		timeSheetTaskAs.setTimeSheet(timeSheet);		
		timesheetService.submitTimeSheet(timeSheet);

	}

}