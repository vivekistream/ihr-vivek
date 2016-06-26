package com.istream.ihr.vo;

public class AddTimesheetReq {
	
	private Integer projectId;
	
	private String date;
	
	private Integer hours;
	
	private String description;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AddTimesheetReq [projectId=" + projectId + ", date=" + date + ", hours=" + hours + ", description="
				+ description + "]";
	}

}
