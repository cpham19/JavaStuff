package cs520.spring.aop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogTest {

    LoggedTask task;
    LoggedTask task2;
    LoggedTask target;

    LogTest()
    {
    }

    public LoggedTask getTask()
    {
        return task;
    }

    public void setTask( LoggedTask task )
    {
        this.task = task;
    }
    

    public LoggedTask getTask2() {
		return task2;
	}

	public void setTask2(LoggedTask task2) {
		this.task2 = task2;
	}

	public LoggedTask getTarget() {
		return target;
	}

	public void setTarget(LoggedTask target) {
		this.target = target;
	}

	public static void main( String[] args )
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
            "aop.xml" );

        LogTest test = (LogTest) context.getBean( "logTest" );
        test.getTask().doSomething();
        test.getTask().doSomethingElse();
        test.getTask().hello();
        
        System.out.println();
        
        test.getTask2().doSomething();
        test.getTask2().doSomethingElse();
        test.getTask2().hello();
        
        context.close();
    }

}
