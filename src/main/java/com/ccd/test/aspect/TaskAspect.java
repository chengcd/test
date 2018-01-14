package com.ccd.test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * Created by Wangmx on 2018/1/10.
 */
@Aspect
@Component
public class TaskAspect {
    private static final Logger logger = LoggerFactory.getLogger(TaskAspect.class);

    @Pointcut("execution(* com.test.controller.TestController.addTask(..))")
    private void addTaskAction(){};

    private ThreadLocal<String> tLocal = new ThreadLocal<String>();

   // @Before("execution(* com.test.controller.TestController.addTask(..)) && args(id,userId,name)")
    public void getInterview(String moid,int taskType,String otherAttr, String actDefName, String taskName,String userId){
        tLocal.set(moid);
    }
    @Around("addTaskAction()")
    public Object aroundInterviewTask(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs();
        Object retVal = pjp.proceed(args);

        try {
            //获取参数
            String id = args[0].toString();
            String name = args[2].toString();
            //业务逻辑处理
        } catch (Throwable e) {
            //异常处理
        }

        return retVal;
    }

    @AfterReturning(returning="result",pointcut="addTaskAction()")
    public void addCount(Object result){

    }
}
