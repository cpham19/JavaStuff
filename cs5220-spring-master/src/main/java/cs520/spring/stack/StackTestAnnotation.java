package cs520.spring.stack;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StackTestAnnotation {

    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
            "stack_annotation.xml" );

        StackTest stackTest = (StackTest) context.getBean( "stackTest" );
        stackTest.test();

        context.close();
    }

}
