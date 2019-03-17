package com.psy.model;

public class Appointment {
	private int id;//咨询师安排时间id
	private String date;
	private int day;
	private int month;
	private String status;
	private List<TimePart> timeList;
	private int is_display;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<TimePart> getTimeList() {
		return timeList;
	}
	public void setTimeList(List<TimePart> timeList) {
		this.timeList = timeList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIs_display() {
		return is_display;
	}
	public void setIs_display(int is_display) {
		this.is_display = is_display;
	}
}
