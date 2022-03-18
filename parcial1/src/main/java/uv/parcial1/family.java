package uv.parcial1;
public class family<T>{

    private final T father;
    private final T mother;
    private final T[] child;
    
    public family (T p, T m, T h[]){
        this.father=p;
        this.mother=m;
        this.child=h;
    }
    
    public T getFather(){
        return father;
    }
    public T getMother(){
        return mother;
    }
    
    public T getChild(int i) {
        return child[i];
    }
    
}
