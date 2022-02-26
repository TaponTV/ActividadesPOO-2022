package uv.interfacebasics;
public class circle implements calculate{

    private final double area;
    
    public circle(double radio){
        this.area = calculateArea(radio,0);
    }
    @Override
    public double calculateArea(double radio, double none){
        double area = Math.PI*Math.pow(radio,2);
        return area;
    }
    
    public Boolean compareTo(Object obj){
        if(!(obj instanceof circle)) return false;
        circle two = (circle) obj;
        return this.area == two.area;
    }

}
