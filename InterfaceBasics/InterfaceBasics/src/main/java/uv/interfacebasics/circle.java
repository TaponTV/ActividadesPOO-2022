package uv.interfacebasics;
public class circle implements calculate{

    private final double area;
    private final double radio;
    
    public circle(Double radio){
        this.radio = radio;
        this.area = calculateArea();
    }
    
    public double calculateArea(){
        double area = Math.PI*Math.pow(radio,2);
        return area;
    }
    
    public int compareTo(circle obj){
        if(this.area == obj.area) return 0;
        return 1;
    }

}
