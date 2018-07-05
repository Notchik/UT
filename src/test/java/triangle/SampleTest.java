package triangle;

import org.testng.Assert;
import org.testng.annotations.*;

public class SampleTest {
    @Test
    public void testSquare1(){
        Assert.assertEquals(new Triangle(3,4,5).getSquare(),6.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testSquare2(){
        Triangle tr = new Triangle(0,0,0);
        tr.getSquare();
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testSquare3(){
        Triangle tr = new Triangle(-2.1,-6,10);
        tr.getSquare();
    }

    @Test
    public void testIsTriangle1(){
        Assert.assertEquals(new Triangle(Math.pow(3.0,100000000000000000000000000000000000000000.0),Math.pow(4.0,100000000000000000000000000000000000000000.0),Math.pow(5.0,100000000000000000000000000000000000000000.0)).checkTriangle(),true);
    }

    @Test
    public void testIsTriangle2(){
        Assert.assertEquals(new Triangle(0.00000000000000000000000000000000000000000000000000000003,0.00000000000000000000000000000000000000000000000000000004,0.00000000000000000000000000000000000000000000000000000005).checkTriangle(),true);
    }

    @Test
    public void testTriangleMessage1(){
        Triangle tr = new Triangle(2,2,-1);
        tr.checkTriangle();
        Assert.assertEquals(tr.getMessage(),"c<=0");
    }

    @Test
    public void testTriangleMessage2(){
        Triangle tr = new Triangle(2,-1,2);
        tr.checkTriangle();
        Assert.assertEquals(tr.getMessage(),"b<=0");
    }

    @Test
    public void testTriangleMessage3(){
        Triangle tr = new Triangle(-1,2,2);
        tr.checkTriangle();
        Assert.assertEquals(tr.getMessage(),"a<=0");
    }

    @Test
    public void testTriangleMessage4(){
        Triangle tr = new Triangle(1,2,3);
        tr.checkTriangle();
        Assert.assertEquals(tr.getMessage(),"a+b<=c");
    }

    @Test
    public void testTriangleMessage5(){
        Triangle tr = new Triangle(2,10,3);
        tr.checkTriangle();
        Assert.assertEquals(tr.getMessage(),"a+c<=b");
    }

    @Test
    public void testTriangleMessage6(){
        Triangle tr = new Triangle(10,1,2);
        tr.checkTriangle();
        Assert.assertEquals(tr.getMessage(),"b+c<=a");
    }

    @Test
    public void testTriangleType1(){
        Triangle tr = new Triangle(3,4,5);
        Assert.assertEquals(tr.detectTriangle(), 8);
    }

    @Test
    public void testTriangleType2(){
        Triangle tr = new Triangle(3,5,4);
        Assert.assertEquals(tr.detectTriangle(), 8);
    }

    @Test
    public void testTriangleType3(){
        Triangle tr = new Triangle(3,3,3);
        Assert.assertEquals(tr.detectTriangle(), 3);
    }

    @Test
    public void testTriangleType4(){
        Triangle tr = new Triangle(1,2,3);
        Assert.assertEquals(tr.detectTriangle(), 4);
    }

    @Test
    public void testTriangleType5(){
        Triangle tr = new Triangle(2,2,3);
        Assert.assertEquals(tr.detectTriangle(), 2);
    }

    @Test
    public void testTriangleType6(){
        double a = 4.0;
        double b = Math.sqrt(a*a + a*a);
        Triangle tr = new Triangle(a,a,b);
        Assert.assertEquals(tr.detectTriangle(), 10);
    }
}
