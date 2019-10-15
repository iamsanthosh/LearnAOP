package com.learnaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

	@Autowired
	private SampleService service;
	
	@GetMapping(path="/")
	@TrackTime
	public String showWelcomwe() {
		service.callServiceMethod();
		return "Welcome";
	}

}
