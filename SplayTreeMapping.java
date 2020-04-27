/**
 * Hoja de Trabajo 9
 * Algoritmos y Estructuras de Datos
 * Sección: 30
 * Fecha de entrega: 27/04/2020
 * Clase SplayTreeMapping
 * Autores:
	Hansel López	carné: 19026 
	Martin España 	carné: 19258
 * Última fecha de modificación: 26/04/2020
 * Versión: 1.0
*/


public class SplayTreeMapping<K extends Comparable<K>, V> implements Mapping<K, V> {
    Association<K,V> assoc;
    private final SplayTree<K,V> tree;

    public SplayTreeMapping() {
        this.tree = new SplayTree<K,V>();
    }

    public boolean isHashing() {
        return false;
    }

    @Override
    public V remove(final K key) {
        return this.tree.remove(new Association<K, V>(key, null)).getValue();
    }

    @Override
    public V put(final Association<K, V> association) {
        final V value = null;
        if (this.tree.isEmpty()) {
            this.tree.setValue(association);
        } else {
            this.tree.add(association, tree);
        }
        return value;
    }

    @Override
    public int size() {
        return this.tree.size();
    }

    @Override
    public boolean searchValue(final String key) {
        return get(key) != null;
    }

    @Override
    public V get(final Object key) {
        
        return null;
    }
}