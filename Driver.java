/**
 * Hoja de Trabajo 9
 * Algoritmos y Estructuras de Datos
 * Sección: 30
 * Fecha de entrega: 27/04/2020
 * Clase Driver
 * Autores:
	Hansel López	carné: 19026
	Martin España 	carné: 19258
 * Última fecha de modificación: 20/04/2020
 * Versión: 1.0
*/
import java.util.Scanner;

public class Driver{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		Factory factory = new Factory();
		Mapping<String, String> mapping = null;
		String input = null;

		//Imprimiendo opciones de mapping
		System.out.println("________________________________________________________--");
    	System.out.println("                 Hoja de Trabajo 6");
    	System.out.println("________________________________________________________--\n");
    	System.out.println("Que implementacion desea utilizar para traducir: \n");
		System.out.println("Escribir: 'HashMap' o 'RedBlackTree'");
		
		while(mapping == null){
			input = sc.nextLine();		
			mapping = factory.getMapping(input);//Instanciando Mapping elegido por medio patron factory
		}

		if(mapping.isHashing()){
			//Hashing code to translate here
		}else{
			//RedBlackTree code to translate here
		}

	}
}