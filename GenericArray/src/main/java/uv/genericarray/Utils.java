package uv.genericarray;

public class Utils {
    public static <T extends Number> T[] ordena(T[] Vector) {
        quicksort(Vector, 0 ,Vector.length-1);
        return Vector;
    }

    public static <T extends Number> void quicksort(T[] vec,int left,int right) {
       int i=left, j=right;
       T pivot = vec[left], aux;
       while(i < j){
           while(vec[i].doubleValue() <= pivot.doubleValue() && i < j) i++;
           while(vec[j].doubleValue() > pivot.doubleValue()) j--;
           if(i < j){
               aux = vec[i];
               vec[i]=vec[j];
               vec[j]=aux;
           }    
       }
       vec[left]=vec[j];
       vec[j]=pivot;
       if(left < (j-1))
           quicksort(vec,left,j-1);
       if(j+1 < right)
           quicksort(vec,j+1,right);
    }
}