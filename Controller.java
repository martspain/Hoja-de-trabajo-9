/**
 * Hoja de Trabajo 9
 * Algoritmos y Estructuras de Datos
 * Sección: 30
 * Fecha de entrega: 27/04/2020
 * Clase Controller
 * Autores:
	Hansel López	carné: 19026 
	Martin España 	carné: 19258
 * Última fecha de modificación: 20/04/2020
 * Versión: 1.0
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.IOException;




public class Controller{
	
	public void runProgram(){
		boolean active = true;
		Scanner screen = new Scanner(System.in);
		
		System.out.println("Bienvenid@ al diccionario UVG!");
		
		while(active){
			System.out.println("###### Menu ###### \nQue desea hacer? \n1. Traducir el texto \n2. Salir ");
			
			try{
				int decision = screen.nextInt();
				
				if(decision == 1){
					
					System.out.println("");
					
					this.readDictionary();
					
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
	
	public void readDictionary(){
		File file = new File("Spanish.txt");
		
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
				
				Association pair = new Association(english, translation);
				this.saveWord(pair);
			}
		}
		catch(Exception e){
			
		}
	}
	
	public void saveWord(Association link){
		
	}
	
	public void readTranslation(){
		
	}
	
	public void createInstance(){
		//Aqui se utiliza el factory
	}
	
}