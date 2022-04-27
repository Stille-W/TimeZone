package com.timeZone.Entity;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Range;

@Entity
public class Date {
	@NotEmpty(message = "{time.currTime.yyyy.empty}")
	@Pattern(regexp = "^[0-9]{1,}$", message = "{time.currTime.yyyy.pattern}")
	private String yyyy;
	@NotEmpty(message = "{time.currTime.MM.empty}")
	@Pattern(regexp = "^[0-9]{1,2}$", message = "{time.currTime.MM.pattern}")
	@Range(min = 1, max = 12, message = "{time.currTime.MM.range}")
	private String MM;
	@NotEmpty(message = "{time.currTime.dd.empty}")
	@Pattern(regexp = "^[0-9]{1,2}$", message = "{time.currTime.dd.pattern}")
	@Range(min = 1, max = 31, message = "{time.currTime.dd.range}")
	private String dd;
	@NotEmpty(message = "{time.currTime.h.empty}")
	@Pattern(regexp = "^[0-9]{1,2}$", message = "{time.currTime.h.pattern}")
	@Range(min = 1, max = 12, message = "{time.currTime.h.range}")
	private String h;
	@NotEmpty(message = "{time.currTime.mm.empty}")
	@Pattern(regexp = "^[0-9]{1,2}$", message = "{time.currTime.mm.pattern}")
	@Range(min = 0, max = 59, message = "{time.currTime.mm.range}")
	private String mm;
	@NotEmpty(message = "{time.currTime.a.empty}")
	private String a;
	
	public String getYyyy() {
		return yyyy;
	}
	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}
	public String getMM() {
		return MM;
	}
	public void setMM(String mM) {
		MM = mM;
	}
	public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	public String getH() {
		return h;
	}
	public void setH(String h) {
		this.h = h;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	
	@Override
	public String toString() {
		return yyyy + "/" + MM + "/" + dd + " " + h + ":" + mm + " " + a ;
	}
	
	
}
