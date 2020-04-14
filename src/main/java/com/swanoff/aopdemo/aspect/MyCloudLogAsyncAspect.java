package com.swanoff.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudLogAsyncAspect {
	
	@Before("com.swanoff.aopdemo.aspect.AopExpressions.forDaoPackageNotGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("=====> Logging to Cloud in async fashion");
	}
}
