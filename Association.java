
public class Association<K extends Comparable<K>, V> {
    private K key;
    private V value;

    public Association(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public int compareTo(Association<K,V> association){
        return key.compareTo(association.key);
    }
}