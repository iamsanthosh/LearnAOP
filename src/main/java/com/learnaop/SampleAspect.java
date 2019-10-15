package com.learnaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SampleAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	//Weaving & Weaver
	@Before("execution(* com.learnaop.*.*(..))")
	public void before(JoinPoint joinPoint){
		//Advice

		logger.info(" Check for user access ");
		logger.info(" Allowed execution for {}", joinPoint);
	}

	@Around("@annotation(com.learnaop.TrackTime)")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		logger.info(" Entering Method:: {}", joinPoint.getSignature().getName());

		joinPoint.proceed();
		logger.info(" Exiting Method:: {}", joinPoint.getSignature().getName());

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info(" Time Taken by {} is {}", joinPoint, timeTaken);
	}
}
