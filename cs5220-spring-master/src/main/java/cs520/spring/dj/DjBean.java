package cs520.spring.dj;

import java.util.Date;

public class DjBean {

    private Integer   a, b;
    private Integer   c, d;

    private Integer[] numbers;

    private Date      now;

    public DjBean( Integer c, Integer d )
    {
        this.c = c;
        this.d = d;
    }

    public void output()
    {
        System.out.println( "a = " + a );
        System.out.println( "b = " + b );
        System.out.println( "c = " + c );
        System.out.println( "d = " + d );

        int sum = 0;
        for( int i = 0; i < numbers.length; ++i )
            sum += numbers[i];
        System.out.println( "sum = " + sum );

        System.out.println( now );
    }

    public Integer getA()
    {
        return a;
    }

    public void setA( Integer a )
    {
        this.a = a;
    }

    public Integer getB()
    {
        return b;
    }

    public void setB( Integer b )
    {
        this.b = b;
    }

    public Integer[] getNumbers()
    {
        return numbers;
    }

    public void setNumbers( Integer[] numbers )
    {
        this.numbers = numbers;
    }

    public Date getNow()
    {
        return now;
    }

    public void setNow( Date now )
    {
        this.now = now;
    }

}
