package cs520.spring.hello;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {

    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
            "hello.xml" );

        Message message = (Message) context.getBean( "msgBean" );
        System.out.println( message.getContent() );

        context.close();
    }

}
