package cs520.spring.stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StackTest {

    @Autowired
    @Qualifier("stack2")
    private Stack stack;

    public StackTest()
    {
    }

    public void test()
    {
        stack.push( "one" );
        stack.push( "two" );
        stack.push( "three" );
        System.out.println( stack.pop() );
        System.out.println( stack.pop() );
        System.out.println( stack.pop() );
    }

    public void setStack( Stack stack )
    {
        this.stack = stack;
    }

    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
            "stack.xml" );

        StackTest stackTest = (StackTest) context.getBean( "stackTest" );
        stackTest.test();

        context.close();
    }

}
