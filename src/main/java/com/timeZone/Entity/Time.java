package com.timeZone.Entity;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Time {
	@NotEmpty(message = "{time.currTimeZone.empty}")
	private String currTimeZone;
	@Valid
	private Date currTime;
	private String goalTimeGMT;
	private String goalTimeEDT;
	private String goalTimeJST;
	private String goalTimePDT;
	private String goalTimeGMT8;
	
	public String getCurrTimeZone() {
		return currTimeZone;
	}
	public void setCurrTimeZone(String currTimeZone) {
		this.currTimeZone = currTimeZone;
	}
	public Date getCurrTime() {
		return currTime;
	}
	public void setCurrTime(Date currTime) {
		this.currTime = currTime;
	}
	public String getGoalTimeGMT() {
		return goalTimeGMT;
	}
	public void setGoalTimeGMT(String goalTimeZoneGMT) {
		this.goalTimeGMT = goalTimeZoneGMT;
	}
	public String getGoalTimeEDT() {
		return goalTimeEDT;
	}
	public void setGoalTimeEDT(String goalTimeZoneEDT) {
		this.goalTimeEDT = goalTimeZoneEDT;
	}
	public String getGoalTimeJST() {
		return goalTimeJST;
	}
	public void setGoalTimeJST(String goalTimeZoneJST) {
		this.goalTimeJST = goalTimeZoneJST;
	}
	public String getGoalTimePDT() {
		return goalTimePDT;
	}
	public void setGoalTimePDT(String goalTimeZonePDT) {
		this.goalTimePDT = goalTimeZonePDT;
	}
	public String getGoalTimeGMT8() {
		return goalTimeGMT8;
	}
	public void setGoalTimeGMT8(String goalTimeGMT8) {
		this.goalTimeGMT8 = goalTimeGMT8;
	}
	
	@Override
	public String toString() {
		return "Time [currTimeZone=" + currTimeZone + ", currTime=" + currTime + ", goalTimeGMT=" + goalTimeGMT
				+ ", goalTimeEDT=" + goalTimeEDT + ", goalTimeJST=" + goalTimeJST + ", goalTimePDT=" + goalTimePDT
				+ ", goalTimeGMT8=" + goalTimeGMT8 + "]";
	}
	
}
