import junit.framework.Assert;
import org.junit.Test;
import uv.interfacebasics.circle;
import uv.interfacebasics.rectangle;
public class MainTest {
    
    @Test
    public void CircleTest(){
        circle circle1 = new circle(6.23);
        circle circle2 = new circle(6.23);
        int resultCircles = circle1.compareTo(circle2);
        Assert.assertEquals(resultCircles, 0);
        
    }
    @Test
    public void RectangleTest(){
        rectangle rec1 = new rectangle(15.0,23.0);
        rectangle rec2 = new rectangle(23.0,15.0);
        int resultRecs = rec1.compareTo(rec2);
        Assert.assertEquals(resultRecs, 0);
    }
}
