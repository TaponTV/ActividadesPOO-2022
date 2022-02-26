package uv.interfacebasics;
public class rectangle implements calculate {
    
    private final double area;
    
    public rectangle(double width, double height){
        this.area = calculateArea(width,height);
    }
    public double calculateArea(double width, double height){
        double area = width*height;
        return area;
    }
    public Boolean compareTo(Object obj){
        if(!(obj instanceof rectangle)) return false;
        rectangle two = (rectangle) obj;
        return this.area == two.area;
    }
}
