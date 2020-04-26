/**
 * Hoja de Trabajo 9
 * Algoritmos y Estructuras de Datos
 * Sección: 30
 * Fecha de entrega: 27/04/2020
 * Clase Factory
 * Autores:
	Hansel López	carné: 19026 
	Martin España 	carné: 19258
 * Última fecha de modificación: 26/04/2020
 * Versión: 1.0
*/

public class Factory{
    public Mapping<String,String> getMapping(String type){
        if(type == null){
			System.out.println("-Se ha ingresado un valor no valido, por favor ingresar de nuevo...");
			return null;
		}

        if(type.equals("HashMap")){
            return new Hashing<String,String>();
        }
        
        else if(type.equals("SplayTree")){
            return new SplayTree();
        }
        
        System.out.println("-Se ha ingresado un valor no valido, por favor ingresar de nuevo...");
        return null;
    }
}