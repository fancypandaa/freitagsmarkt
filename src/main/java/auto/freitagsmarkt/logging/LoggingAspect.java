package auto.freitagsmarkt.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
    @Pointcut("execution(* auto.freitagsmarkt.controller.*.*(..)) || execution(* auto.freitagsmarkt.service.*.*(..))")
    public void actionMethods(){}

    @Before("actionMethods()")
    public void logBefore(JoinPoint joinPoint){
        log.info("Entering Method: {} with Arguments: {}",joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
    }
    @Before("execution(* auto.freitagsmarkt.*.*(..))")
    public void logDebug(JoinPoint joinPoint){
        log.info("Debugging - Method: {} with Arguments: {}",joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(value = "actionMethods()",returning = "res")
    public void logAfterReturning(JoinPoint joinPoint,Object res){
        log.info("Existing method: {} with res: {}",joinPoint.getSignature(), res);
    }
    @AfterThrowing(value = "actionMethods()",throwing = "exception")
    public void logBeforeThrowing(JoinPoint joinPoint,Throwable exception){
        log.error("Exception in method: {} with res: {}",joinPoint.getSignature(), exception.getMessage());
    }

}
