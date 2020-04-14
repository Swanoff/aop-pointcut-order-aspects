package com.swanoff.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.swanoff.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.swanoff.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.swanoff.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNotGetterSetter() {}
	
	@Before("forDaoPackageNotGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====> Executing @Before advice on method");
	}
	
	@Before("forDaoPackageNotGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====> Performing API analytics");
	}
	
	@Before("forDaoPackageNotGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("\n=====> Logging to Cloud in async fashion");
	}
}
