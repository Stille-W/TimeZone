package com.timeZone.Controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public class TestTimeZone {
	
	public static void main(String[] args) {
		new TestTimeZone().run();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a");
//		System.out.println(formatter.format(LocalDateTime.now()));
	}
	
	public void run() {
		Instant ins = date2Instant("2022", "05", "01", "11", "30", "AM");
		System.out.println(chg2EST(ins));
	}
	
	public void choose(String timeZone) {
		switch (timeZone) {
		case "GMT":
			
			break;

		default:
			break;
		}
	}
	
	public String dateFormat(ZonedDateTime zDateTime) {
		// Fri Jan 31 21:20:50 CST 2014
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd h:mm a zzz yyy", Locale.ENGLISH);
		String zDateStr = zDateTime.format(formatter);
		return zDateStr;
	}
	
	public Instant date2Instant(String yyyy, String MM, String dd, String hh, String mm, String a) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd h:mm a", Locale.ENGLISH);
		String dateStr = yyyy+"/"+ MM +"/"+dd+" "+hh+":"+mm+" "+a;
		LocalDateTime date = LocalDateTime.parse(dateStr, formatter);
		System.out.println(date);
		return date.atZone(ZoneId.systemDefault()).toInstant();
	}
	
	public String chg2GMT(Instant instant) {
		ZonedDateTime date = instant.atZone(ZoneId.of("GMT"));
		return dateFormat(date);
	}
	
	public String chg2EST(Instant instant) {
		ZonedDateTime date = instant.atZone(ZoneId.of("EST5EDT"));
		return dateFormat(date);
	}
	
	public String chg2JST(Instant instant) {
		ZonedDateTime date = instant.atZone(ZoneId.of("Japan"));
		return dateFormat(date);
	}
	
	public String chg2PST(Instant instant) {
		ZonedDateTime date = instant.atZone(ZoneId.of("PST8PDT"));
		return dateFormat(date);
	}
	
}
