package cs520.spring.dj;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DjTest {

    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
            "dj.xml" );

        DjBean dj = (DjBean) context.getBean( "dj" );
        dj.output();

        context.close();
    }

}
