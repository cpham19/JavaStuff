package cs520.spring.aop;

public class LoggedTask2 implements LoggedTask {

    public LoggedTask2()
    {
    }

    public void doSomething()
    {
        System.out.print( "Task2: doing something important ..." );
        System.out.println( " Done!" );
    }

    public void doSomethingElse()
    {
        System.out.print( "Task2: doing something very important ..." );
        System.out.println( " Done!" );
    }

    public void hello()
    {
        System.out.println( "LoggedTask2 says hello!" );
    }

}
