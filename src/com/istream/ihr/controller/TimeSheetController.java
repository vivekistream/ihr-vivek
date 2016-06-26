package com.istream.ihr.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.istream.ihr.orm.Employee;
import com.istream.ihr.orm.Project;
import com.istream.ihr.orm.TimeSheet;
import com.istream.ihr.service.TimeSheetService;
import com.istream.ihr.vo.AddTimesheetReq;
import com.istream.ihr.vo.AddTimesheetRes;

@RestController
public class TimeSheetController {
	
	@Autowired
	TimeSheetService timesheetService;
	
	@RequestMapping(value = "/timesheet/", method = RequestMethod.POST)
    public ResponseEntity<AddTimesheetRes> createEmployee(@RequestBody AddTimesheetReq addTimesheetReq) {
		System.out.println(addTimesheetReq);
		TimeSheet timeSheet = convertReqToDao(addTimesheetReq);
		AddTimesheetRes response = timesheetService.submitTimeSheet(timeSheet);		
        return new ResponseEntity<AddTimesheetRes>(response, HttpStatus.CREATED);
    }

	private TimeSheet convertReqToDao(AddTimesheetReq addTimesheetReq) {
		Employee employee = new Employee();
		 employee.setEmployeeId(124);
		 Project project = new Project();
		 project.setProjectId(addTimesheetReq.getProjectId());
		 Date startDate = new Date();
		 int billedHours = addTimesheetReq.getHours();
		 Integer nonBilledHours = 1;
		 String note = "note";
		 String description = addTimesheetReq.getDescription();
		 String status = "NA";
		 Date creationTs = new Date();
		 Date lastUpdateTs = new Date();
			
		TimeSheet timeSheet = new TimeSheet(employee, project, startDate, billedHours, nonBilledHours, note, status, 
				creationTs, lastUpdateTs, description);
		return timeSheet;
	}

}
