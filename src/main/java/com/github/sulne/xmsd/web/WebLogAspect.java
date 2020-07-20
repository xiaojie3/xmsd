package com.github.sulne.xmsd.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.sulne.xmsd.pojo.WebLog;
import com.github.sulne.xmsd.service.WebLogService;
import com.github.sulne.xmsd.tool.Tools;

@Aspect
@Component
public class WebLogAspect {
	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
	@Autowired
	private WebLogService service;
	private WebLog webLog;

	@Pointcut("execution(public * com.github.sulne.xmsd.controller.*.*(..))")
	public void logPointCut() {
	}

	@Before("logPointCut()")
	public void doBefore(JoinPoint joinPoint) throws IOException, ServletException {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String requestedWith = request.getHeader("x-requested-with");
		if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {
			logger.info("是ajax请求");
		} else {
			logger.info("不是ajax请求");
		}
		// 记录下请求内容
		webLog = new WebLog(Tools.UUID(), request.getRequestURI(),
				joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
				request.getRemoteAddr(), request.getMethod(), Arrays.toString(joinPoint.getArgs()), Tools.date(),
				"00000");

	}

	@AfterReturning(returning = "ret", pointcut = "logPointCut()") // returning的值和doAfterReturning的参数名一致
	public void doAfterReturning(Object ret) {
		// 处理完请求，返回内容
		//webLog.setRet(ret.toString());
		logger.info(webLog.toString());
		service.insert(webLog);

	}

	@Around("logPointCut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object ob = pjp.proceed();// ob 为方法的返回值
		webLog.setCost((System.currentTimeMillis() - startTime) + "ms");
		return ob;
	}
}
