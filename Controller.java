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

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Controller{
	
	Mapping<String, String> tree; //Es el mapa utilizado
	
	//Metodo que contiene el menu que se muestra al usuario
	public void runProgram(){
		boolean active = true;
		Scanner screen = new Scanner(System.in);
		
		System.out.println("Bienvenid@ al diccionario UVG!");
		
		while(active){
			System.out.println("\n \n###### Menu ###### \nQue desea hacer? \n1. Traducir el texto \n2. Salir ");
			
			try{
				int decision = screen.nextInt();
				
				if(decision == 1){
					
					System.out.println("Que implementacion desea utilizar? \n1. HashMap \n2. SplayTree ");
					
					try{
						int decision_two = screen.nextInt();
						
						if(decision_two == 1){
							this.createInstance(1);
						}
						else if(decision_two == 2){
							this.createInstance(2);
						}
						else{
							System.out.println("Debe ingresar una implementacion valida ");
						}
						
						long startTime = System.nanoTime();
						
						this.readDictionary(); //Esto lee el archivo de texto y guarda las palabras en la implementacion seleccionada (HashMap tree por default)
						
						long endTime = System.nanoTime();
						
						long elapsedTime = endTime - startTime;
						
						System.out.println("Tiempo transcurrido: " + elapsedTime);
						
						this.readTranslation(); //Esto traduce la informacion utilizando el tree implementado y muestra el resultado en pantalla
						
					}
					
					catch(Exception e){
						System.out.println("Ocurrio un error, revise haber ingresado los datos correctamente.");
					}
					
					
					
				}
				else if(decision == 2){
					System.out.println("Gracias por utilizar el programa. ");
					active = false;
				}
				else{
					System.out.println("Porfavor ingrese una opcion valida...");
				}
			}
			catch(Exception e){
				System.out.println("Porfavor ingrese una opcion valida...");
				active = false;
			}
		}
		
		
	}
	
	//Metodo para leer el archivo del diccionario y guardar las asociaciones en el arbol (crear el diccionario)
	public void readDictionary(){
		File file = new File("Spanish.txt"); //Nombre del archivo que contiene los datos del diccionario
		
		try{
			Scanner reader = new Scanner(file);
			
			while(reader.hasNext()){
				String line = reader.nextLine();
				String english = "";
				String translation = "";
				String[] words;
				
				if(!(line.indexOf("#") == 0) && !(line.indexOf(" ") == 0)){ //Se verifica que la palabra no empieze con # (que son comentarios) y que no sea una linea vacia
					words = line.split("	");
					english = words[0];
					
					if(words[1].indexOf(",") >= 0){
						translation = words[1].substring(0,words[1].indexOf(","));
					}
					else if(words[1].indexOf("(") >= 0){
						translation = words[1].substring(0,words[1].indexOf("("));
					}
					else if(words[1].indexOf("[") >= 0){
						translation = words[1].substring(0,words[1].indexOf("["));
					}
					else{
						translation = words[1];
					}
					
				}
				
				Association<String, String> pair = new Association<String, String>(english, translation);
				this.saveWord(pair);
			}
		}
		catch(Exception e){
			
		}
	}
	
	//Metodo para guardar las asociaciones en el diccionario
	public void saveWord(Association<String,String> link){
		tree.put(link);
	}
	
	//Metodo para leer el archivo de texto donde esta el texto que se desea traducir y buscar la traduccion en el arbol
	public void readTranslation(){
		File document = new File("texto.txt"); //Nombre del archivo del cual se va a traducir
		
		System.out.println("\n");
		
		try{
			Scanner reader = new Scanner(document);
			
			while(reader.hasNext()){
				String line = reader.nextLine();
				String[] words;
				String translated = "";
				
				words = line.split(" ");
				
				for(int i = 0; i < words.length; i++){
					String key = words[i];
					key = key.toLowerCase();
					
					if(tree.searchValue(key)){
						translated = tree.get(key);
					}
					else{
						translated = "*" + key + "*";
					}
					
					System.out.print(translated + " ");
				}
				System.out.print("\n");
				
			}
		}
		catch(Exception e){
			
		}
	}
	
	//Metodo para crear la instancia solicitada
	public void createInstance(int flag){
		Factory creator = new Factory();
		if(flag == 1){ //Se utiliza hash map
			tree = creator.getMapping("HashMap");
		}
		else if(flag == 2){ //Se utiliza rdt
			tree = creator.getMapping("SplayTree");
		}
	}
	
}