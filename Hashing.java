import java.util.HashMap;

public class Hashing<K extends Comparable<K>, V> implements Mapping<K,V>{
    protected HashMap<K,V> map = new HashMap<K,V>();

    public boolean isHashing(){
        return true;
    }

    public V remove(K key){
        return map.remove(key);
    }

    public V put(Association<K,V> association){
        return map.put((K)association.getKey(), (V)association.getValue());
    }

    public int size(){
		return map.size();
	}

	public V get(Object key){
		return map.get(key);
    }
    
    public boolean searchValue(String searched){
		if (map.containsKey(searched)) {
			return true;
		}
		return false;
	}
}