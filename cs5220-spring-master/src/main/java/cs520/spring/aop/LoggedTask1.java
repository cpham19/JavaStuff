package cs520.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggedTask1 implements LoggedTask {

    private static Logger logger = LoggerFactory.getLogger( LoggedTask1.class );

    public LoggedTask1()
    {
    }

    public void doSomething()
    {
        logger.info( "From LoggedTask1: start doing something." );

        System.out.print( "Task1: doing something important ..." );
        System.out.println( " Done!" );

        logger.info( "From LoggedTask1: finished." );
    }

    public void doSomethingElse()
    {
        logger.info( "start doing something else." );

        System.out.print( "Task1: doing something very important ..." );
        System.out.println( " Done!" );

        logger.info( "finished." );
    }

    public void hello()
    {
        System.out.println( "LoggedTask1 says hello!" );
    }

}
