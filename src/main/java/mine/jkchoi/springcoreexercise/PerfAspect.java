package mine.jkchoi.springcoreexercise;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    /*
     * Around : Advice
     * execution : Point cut 정의
     */
    //@Around("execution(* mine.jkchoi..*.EventService.*(..))")
    @Around("@annotation(PerfLogging)") //PerfLoggin Annotaion을 붙인 모든 Method에 적용
    //@Around("bean(simpleEventService)") //지정된 모든 빈에 적용
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();

        Object retVal = pjp.proceed();

        System.out.println(System.currentTimeMillis() - begin);

        return retVal;
    }

    @Before("bean(simpleEventService)")
    public void hello() {
        System.out.println("Hello =====");
    }

}
