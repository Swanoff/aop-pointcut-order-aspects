package com.swanoff.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.swanoff.aopdemo.aspect.AopExpressions.forDaoPackageNotGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====> Executing @Before advice on method");
	}
}
