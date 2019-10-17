package cs520.spring.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

@SuppressWarnings("rawtypes")
public class LoggingAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    public void before( Method method, Object[] args, Object target )
        throws Throwable
    {
        Class targetClass = target.getClass();
        Logger log = LoggerFactory.getLogger( targetClass );

        log.info( "From " + targetClass.getSimpleName()
            + ": start doing something." );
    }

    public void afterReturning( Object returnValue, Method method,
        Object[] args, Object target ) throws Throwable
    {
        Class targetClass = target.getClass();
        Logger log = LoggerFactory.getLogger( targetClass );

        log.info( "From " + targetClass.getSimpleName() + ": finished." );
    }

}
