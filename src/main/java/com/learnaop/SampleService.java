package com.learnaop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class SampleService {
	
	@Resource
	private SampleService ser;
	@TrackTime
	public void callServiceMethod() {
		ser.callDAOMethod();
	}
	@TrackTime
	public void callDAOMethod() {
		
	}
}
