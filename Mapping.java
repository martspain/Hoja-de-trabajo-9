/**
 * Hoja de Trabajo 9
 * Algoritmos y Estructuras de Datos
 * Sección: 30
 * Fecha de entrega: 27/04/2020
 * Interface Mapping
 * Autores:
	Hansel López	carné: 19026 
	Martin España 	carné: 19258
 * Última fecha de modificación: 26/04/2020
 * Versión: 1.0
*/

public interface Mapping<K extends Comparable<K>,V> {
    public boolean isHashing();

    public V remove(K key);

    public V put(Association<K,V> association);

    public int size();

    public boolean searchValue(String searched);

    public V get(Object key);
}
