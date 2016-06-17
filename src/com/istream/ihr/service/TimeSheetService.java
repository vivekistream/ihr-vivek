package com.istream.ihr.service;

import java.util.List;

import com.istream.ihr.orm.TimeSheet;
import com.istream.ihr.vo.TimesheetSearch;

public interface TimeSheetService {
	
	public List<TimeSheet> getTimeSheets(TimesheetSearch searchRequest);
	
	public void submitTimeSheet(TimeSheet timeSheet);
	
	public void approveTimeSheet(TimeSheet timeSheet);	
	

}
