package uv.genericarray;
import java.util.Arrays; 
public class Main {
    public static void main(String[] args){
        Integer[] intVector = {102,99,12,19,21,111,345,25,77,81};
        Integer[] result = Utils.ordena(intVector);
        System.out.println(Arrays.asList(result));
        
        Float [] floatVector = { 19.1f, 456.6f, 23.45f, 12.34f, 11.11f, 354.55f, 78.45f, 28.33f, 45.99f, 108.88f};
        Float [] result2 = Utils.ordena(floatVector);
        System.out.println(Arrays.asList(result2));
//        String [] strVector = {"zz", "aa", "cc", "hh", "bb", "ee", "ll"};
//        String [] result3 = Utils.ordena (strVector);
    }
}
