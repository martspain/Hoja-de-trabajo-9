/**
 * Hoja de Trabajo 9
 * Algoritmos y Estructuras de Datos
 * Sección: 30
 * Fecha de entrega: 27/04/2020
 * Clase Controller
 * Autores:
	Hansel López	carné: 19026 
	Martin España 	carné: 19258
 * Última fecha de modificación: 26/04/2020
 * Versión: 1.0
*/

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