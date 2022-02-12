package uv.generictuple;
public class Main {
    public static void main(String[] args){
        
        GenericTupla<Double, Double> point1 = new GenericTupla<>(9.0, 2.0);
        GenericTupla<Double, Double> point2 = new GenericTupla<>(9.0, 2.0);
        boolean aux = Utilities.compare(point1, point2);
        System.out.println ("Los objetos son iguales? " + aux); 
    }
    
}
//Alan Eduardo Tapia Vazquez
//Matricula S19002886