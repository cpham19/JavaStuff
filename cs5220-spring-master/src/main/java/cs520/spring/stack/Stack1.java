package cs520.spring.stack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Stack1 implements Stack {

    private List<String> list;

    public Stack1()
    {
        list = new ArrayList<String>();
    }

    public void push( String s )
    {
        list.add( s );
    }

    public String pop()
    {
        int last = list.size() - 1;
        String s = null;

        if( last >= 0 )
        {
            s = list.get( last );
            list.remove( last );
        }

        return s;
    }

}
