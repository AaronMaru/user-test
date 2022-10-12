package com.example.usertest.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Aspect
@Component
public class LoggingAdvice {

    /**
     * We set log in controller and Service
     * and for class StructureRS not is log target
     */
    @Pointcut(value = "execution(* com.example.usertest.controller.*.*(..) )\"" +
            " + \"&& @target(* com.example.usertest.service.user.UserIP.*(..) )" +
            " + \"&& !@target(com.example.usertest.response.StructureRS)")
    public void myPointcut() {

    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        log.info("-----------------------log Start---------------------------------------------");
        log.info(className + " : " + methodName + "()");
        log.info("Request : " + mapper.writeValueAsString(array));
        Object object = pjp.proceed();
        log.info(className + " : " + methodName + "()");
        log.info("Response : " + mapper.writeValueAsString(object));
        log.info("-----------date:" + new Date());
        log.info("----------------------- log end---------------------------------------------");
        return object;
    }


}
