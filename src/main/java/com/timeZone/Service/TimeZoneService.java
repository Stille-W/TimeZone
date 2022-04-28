package com.timeZone.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.timeZone.Entity.Time;
import com.timeZone.Entity.TimeZone;

@Service
public class TimeZoneService {
	private List<Time> times = new CopyOnWriteArrayList<>();
	private List<TimeZone> timeZones = new CopyOnWriteArrayList<>();
	
	{
		timeZones.add(new TimeZone("GMT","GMT"));
		timeZones.add(new TimeZone("EDT/EST","EST5EDT"));
		timeZones.add(new TimeZone("JST","Japan"));
		timeZones.add(new TimeZone("PDT/PST","PST8PDT"));
		timeZones.add(new TimeZone("GMT+8","Asia/Taipei"));
	}
	
	public List<TimeZone> qryTimeZones() {
		return timeZones;
	}
	
	public List<Time> qryTimes() {
		return times;
	}
	
	public synchronized Boolean add(Time time) {
		int prevousSize = times.size();
		Integer yyyy = Integer.parseInt(time.getCurrTime().getYyyy());
		Integer MM = Integer.parseInt(time.getCurrTime().getMM());
		Integer dd = Integer.parseInt(time.getCurrTime().getDd());
		Integer h = Integer.parseInt(time.getCurrTime().getH());
		Integer mm = Integer.parseInt(time.getCurrTime().getMm());
		String a = time.getCurrTime().getA();
		String currTimeZone = time.getCurrTimeZone();
		
		Instant ins = date2Instant(yyyy, MM, dd, h, mm, a, currTimeZone);
		
		ZonedDateTime currDate = ins.atZone(ZoneId.of(currTimeZone));
		String curr = dateFormat(currDate);
		String cTimeZone = curr.split("\\s+")[3];
		
		String GMT = chg2GMT(ins);
		String EDT = chg2EDT(ins);
		String JST = chg2JST(ins);
		String PDT = chg2PDT(ins);
		String GMT8 = chg2GMT8(ins);
		
		time.setGoalTimeGMT(GMT);
		time.setGoalTimeEDT(EDT);
		time.setGoalTimeJST(JST);
		time.setGoalTimePDT(PDT);
		time.setGoalTimeGMT8(GMT8);
		
		time.setCurrTimeZone(cTimeZone);
		
		times.add(time);
		System.out.println(time);
		int nextSize = times.size();
		return nextSize > prevousSize;
	}
	
	public synchronized Boolean delete(int index) {
		if(index <0 || times.size() == 0 || index >= times.size()) {
			return false;
		}
		times.remove(index);
		return true;
	}
	
	public String dateFormat(ZonedDateTime zDateTime) {
		// Fri Jan 31 9:20 PM CST 2014
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE-MMM-dd h:mm a zzz", Locale.ENGLISH);
		String zDateStr = zDateTime.format(formatter);
		return zDateStr;
	}
	
	public Instant date2Instant(Integer yyyy, Integer MM, Integer dd, Integer hh, Integer mm, String a, String currTimeZone) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y/M/d h:m a", Locale.ENGLISH);
		String dateStr = yyyy+"/"+ MM +"/"+dd+" "+hh+":"+mm+" "+a;
		LocalDateTime date = LocalDateTime.parse(dateStr, formatter);
//		System.out.println(date);
		return date.atZone(ZoneId.of(currTimeZone)).toInstant();
	}
	
	public String chg2GMT(Instant instant) {
		ZonedDateTime date = instant.atZone(ZoneId.of("GMT"));
		return dateFormat(date);
	}
	
	public String chg2EDT(Instant instant) {
		ZonedDateTime date = instant.atZone(ZoneId.of("EST5EDT"));
		return dateFormat(date);
	}
	
	public String chg2JST(Instant instant) {
		ZonedDateTime date = instant.atZone(ZoneId.of("Japan"));
		return dateFormat(date);
	}
	
	public String chg2PDT(Instant instant) {
		ZonedDateTime date = instant.atZone(ZoneId.of("PST8PDT"));
		return dateFormat(date);
	}

	public String chg2GMT8(Instant instant) {
		ZonedDateTime date = instant.atZone(ZoneId.of("Asia/Taipei"));
		return dateFormat(date);
	}
}
