package com.learnaop;

import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnAopApplication.class, args);
		
		ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
		URL[] urLs = ((URLClassLoader)sysClassLoader).getURLs();
		for (URL url : urLs) {
		    System.out.println(url.getFile());
		}

	}

}
