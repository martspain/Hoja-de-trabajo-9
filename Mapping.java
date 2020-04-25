
public interface Mapping<K extends Comparable<K>,V> {
    public boolean isHashing();

    public V remove(K key);

    public V put(Association<K,V> association);

    public int size();

    public boolean searchValue(String searched);

    public V get(Object key);
}
