package cs520.spring.stack;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Stack2 implements Stack {

    @Resource(name = "arrayList")
    private List<String> list;

    public Stack2()
    {
    }

    public void setList( List<String> list )
    {
        this.list = list;
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
