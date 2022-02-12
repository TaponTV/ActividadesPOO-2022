
package uv.generictuple;
public class Utilities{
    
    public static <T extends GenericTupla> boolean compare (T point1, T point2){
        return point1.getKey().equals(point2.getKey()) && point1.getValue().equals(point2.getValue());
    }
    
}
//Alan Eduardo Tapia Vazquez
//Matricula S19002886
