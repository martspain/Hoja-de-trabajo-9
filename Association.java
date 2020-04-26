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