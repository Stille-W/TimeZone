package com.timeZone.Controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.timeZone.Entity.Time;
import com.timeZone.Entity.TimeZone;
import com.timeZone.Service.TimeZoneService;

@Controller
@RequestMapping("/convert")
public class TimeZoneController {
	
	@Autowired
	private TimeZoneService timeZoneService;
	
	@GetMapping("/")
	public String getTime(@ModelAttribute Time time, Model model ) {
		model.addAttribute("_method", "POST");
		model.addAttribute("times", timeZoneService.qryTimes());
		model.addAttribute("timeZones", timeZoneService.qryTimeZones());
		return "timezone";
	}
	
	@PostMapping("/")
	public String chgTime(@Valid Time time, BindingResult result, Model model) {
		// 是否有錯誤發生
			if (result.hasErrors()) {
				model.addAttribute("_method", "POST");
				model.addAttribute("times", timeZoneService.qryTimes());
				model.addAttribute("timeZones", timeZoneService.qryTimeZones());
				return "timezone";
			}
		timeZoneService.add(time);
		return "redirect:./";
	}
	
	@DeleteMapping("/{index}")
	public void delTime(@PathVariable("index") Integer index, Time time) {
		timeZoneService.delete(index);
	}
	
	@DeleteMapping("/")
	public void delAllTime() {
		List<Time> timeList = timeZoneService.qryTimes();
		System.out.println(timeList.size());
		for (int i = 0; i < timeList.size(); i++) {
			timeZoneService.delete(i);
			System.out.println(i);
			i--;
			
		}
	}
}
