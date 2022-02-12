
package uv.generictuple;
public class GenericTupla<K, V> {
    private final K key;
    private final V value;
    
    public GenericTupla(K key, V value){
        this.key = key;
        this.value = value;
    }
    
     public K getKey(){
         return key;
     }
     
     public V getValue(){
         return value;
     }
     
     @Override
     public String toString(){
         return String.format("(%s, %s)",key.toString(),value.toString());
     }
}
//Alan Eduardo Tapia Vazquez
//Matricula S19002886