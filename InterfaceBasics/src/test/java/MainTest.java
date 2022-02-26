import junit.framework.Assert;
import org.junit.Test;
import uv.interfacebasics.circle;
import uv.interfacebasics.rectangle;
public class MainTest {
    
    @Test
    public void SortTest(){
        circle circle1 = new circle(6.23);
        circle circle2 = new circle (2.64);
        
        rectangle rec1 = new rectangle(15,23);
        rectangle rec2 = new rectangle (23,15);
        boolean resultCircles = circle1.compareTo(circle2);
        boolean resultRecs = rec1.compareTo(rec2);
        
        Assert.assertEquals(resultCircles, false);
        Assert.assertEquals(resultRecs, true);
        
    }
}
