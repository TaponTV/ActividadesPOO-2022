package uv.interfacebasics;
public class rectangle implements calculate {
    
    private final double area;
    private final double width;
    private final double height;
    
    public rectangle(double width, double height){
        this.width = width;
        this.height = height;
        this.area = calculateArea();
    }
    
    public double calculateArea(){
        double area = this.width * this.height;
        return area;
    }
    
    public int compareTo(rectangle obj){
        if(this.area == obj.area) return 0;
        return 1;
    }
}
