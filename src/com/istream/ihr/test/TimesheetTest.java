package com.istream.ihr.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.istream.ihr.orm.Employee;
import com.istream.ihr.orm.Project;
import com.istream.ihr.orm.TimeSheet;
import com.istream.ihr.service.TimeSheetService;
import com.istream.ihr.vo.TimesheetSearchReq;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:E:\\GIT-Backup\\GIT-Workspace\\Istream\\integrate\\iHR\\WebContent\\WEB-INF\\applicationContext.xml" })
public class TimesheetTest {

	@Autowired
	TimeSheetService timesheetService;

	@Test
	public void submitTimeSheet() {
		 Employee employee = new Employee();
		 employee.setEmployeeId(124);
		 Project project = new Project();
		 project.setProjectId(1);
		 Date startDate = new Date();
		 int billedHours = 80;
		 Integer nonBilledHours = 20;
		 String note = "note";
		 String description = "IHR Project Implementation.";
		 String status = "NA";
		 Date creationTs = new Date();
		 Date lastUpdateTs = new Date();
			
		TimeSheet timeSheet = new TimeSheet(employee, project, startDate, billedHours, nonBilledHours, note, status, 
				creationTs, lastUpdateTs, description);
		timesheetService.submitTimeSheet(timeSheet);

	}
	
	//@Test
	public void getTimeSheets() {
		TimesheetSearchReq searchRequest = new TimesheetSearchReq();
		searchRequest.setEmployeeId(125L);
		searchRequest.setMonth(6);
		searchRequest.setYear(2016);
		List<TimeSheet> timesheets = timesheetService.getTimeSheets(searchRequest);
		timesheets.forEach(t -> System.out.println(t));
	}

}