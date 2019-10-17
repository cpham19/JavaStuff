package cs520.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingInterceptor implements MethodInterceptor {

    @SuppressWarnings("rawtypes")
    public Object invoke( MethodInvocation invocation ) throws Throwable
    {
        Class targetClass = invocation.getMethod().getDeclaringClass();
        Logger logger = LoggerFactory.getLogger( targetClass );

        logger.info( "From " + targetClass.getSimpleName()
            + ": start doing something." );
        Object result = invocation.proceed();
        logger.info( "From " + targetClass.getSimpleName() + ": finished" );

        return result;
    }

}
