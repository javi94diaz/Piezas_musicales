package partituras2;

import java.io.*;
import java.util.Scanner;
import java.nio.file.Files;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;


public class AlgoritmoTest {
	
    public static void main (String[] Args) throws IOException {
        
    	// Para que el usuario introduzca datos
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        
        int opcion = 0;
        
        Pieza pieza = new Pieza();
        
        // Ventana para mostrar imagenes de las piezas
        JFrame frame = new JFrame("Mi primera GUI");      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        frame.setSize(300, 300);      
        JButton boton = new JButton("Presionar");
        frame.setVisible(false);
        
        
        // Chequear si existe el archivo auxiliar "bibliocopia.txt" y eliminarlo en ese caso       
        File auxiliar = new File("bibliocopia.txt");
        if (auxiliar.exists() ) {
        	auxiliar.delete();
        	System.out.println("Eliminado bibliocopia residual");
        }
        else {
        	System.out.println("No habia fichero residual 1");
        }
        
        
        File auxiliar2 = new File("bibliocopia2.txt");
        if (auxiliar2.exists() ) {
        	auxiliar2.delete();
        	System.out.println("Eliminado bibliocopia2 residual");
        }
        else {
        	System.out.println("No habia fichero residual 2");
        }
        
        
        
        while (opcion != 6) {
        	
        	// Menu de opciones para el usuario
        	System.out.printf("\nIntroduzca una opcion del 1 al 5: \n");
        	System.out.printf("\n1) Crear pieza\n2) Modificar pieza\n3) Listar piezas\n4) Mostrar pieza\n5) Eliminar pieza\n6) Salir\n");
        	opcion = scan.nextInt();
        	frame.setVisible(false);
        	
        	if (opcion == 1) { // Crear una pieza
        		
        		System.out.printf("Introduzca nombre: \n");
        		String nombre = scan2.nextLine();
        		pieza.SetNombre( nombre );
        		
        		System.out.printf("Introduzca compositor: \n");
        		String comp = scan2.nextLine();
        		pieza.SetCompositor( comp );
        		
        		System.out.printf("Introduzca nivel: \n");
        		int nivel = scan.nextInt();
        		pieza.SetNivel( nivel );
        		
        		System.out.printf("Introduzca armadura de clave: \n");
        		String armad = scan2.nextLine();
        		pieza.SetArmaduraDeClave( armad );
        		
        		System.out.printf("Introduzca numero de compases: \n");
        		int compases = scan.nextInt();
        		pieza.SetCompases( compases );
        		
        		System.out.printf("Desea introducir una imagen?\n");
        		String confirmacion = scan2.nextLine();
        		
        		if ( confirmacion.equals("si") || confirmacion.equals("Si") ) {
        			
        			System.out.printf("Introduzca nombre de la imagen de la carpeta FOTOS: \n");
            		String nombreImagen = scan2.nextLine();
            		pieza.SetNombreImagen(nombreImagen);
        			
        		}
        		else {
        			pieza.SetNombreImagen("-");
        		}
        		
        		System.out.printf("Desea introducir un archivo de audio?\n");
        		confirmacion = scan2.nextLine();
        		
        		if ( confirmacion.equals("si") || confirmacion.equals("Si") ) {
        			
        			System.out.printf("Introduzca nombre del audio de la carpeta AUDIOS: \n");
            		String audio = scan2.nextLine();
            		pieza.SetAudio(audio);
        			
        		}
        		else {
        			pieza.SetAudio("-");
        		}
        		
        		// Guardamos los datos en el archivo bilbioteca.txt
        		FileWriter biblioteca = null;
                PrintWriter pw = null;
                
                try
                {
                    biblioteca = new FileWriter("biblioteca.txt", true);
                    pw = new PrintWriter(biblioteca);

                    pw.printf("%s:%s:%d:%s:%d:%s:%s:\n", pieza.getNombre(), pieza.getCompositor(), pieza.getNivel(), pieza.getArmaduraDeClave(), pieza.getCompases(), pieza.getNombreImagen(), pieza.getAudio() );

                    System.out.printf("Pieza guardada en la biblioteca\n");
                    
                } catch (Exception e) {
                	System.out.printf("error");
                    e.printStackTrace();
                } finally {
                	biblioteca.close();
                }
                	
        	}
        	else if (opcion == 2) { // Modificar una pieza y sus valores
        		
        		// Usuario introduce numero de linea para modificar
        		System.out.printf("Introduzca numero de la pieza que quiere modificar: \n");
        		
        		int lineamodif = scan.nextInt();
        		
        		// Guardamos las lineas en otro fichero copia y modificamos la indicada
        		File biblioteca = new File("biblioteca.txt");
        		File bibliocopia2 = new File("bibliocopia2.txt");

        		BufferedReader br = new BufferedReader(new FileReader(biblioteca));
        		BufferedWriter writer = new BufferedWriter(new FileWriter(bibliocopia2));
        		
        		String linea = "";
        		int i = 0;
        		
        		while( linea != null) {
        			
        			i++;
        			linea = br.readLine();
        			
        		    if( i == lineamodif ) { // Le pedimos al usuario los datos modificados
        		    	        		    	
        		    	System.out.printf("Introduzca nombre: \n");
                		String nombre = scan2.nextLine();
                		                		
                		System.out.printf("Introduzca compositor: \n");
                		String comp = scan2.nextLine();
                		                		
                		System.out.printf("Introduzca nivel: \n");
                		int nivel = scan.nextInt();
                		                		
                		System.out.printf("Introduzca armadura de clave: \n");
                		String armad = scan2.nextLine();
                		                		
                		System.out.printf("Introduzca numero de compases: \n");
                		int compases = scan.nextInt();
                		
                		System.out.printf("Desea introducir una imagen?\n");
                		String confirmacion = scan2.nextLine();
                		
                		String imagen = "";
                		
                		if ( confirmacion.equals("si") || confirmacion.equals("Si") ) {
                			
                			System.out.printf("Introduzca nombre de la imagen de la carpeta FOTOS: \n");
                    		imagen = scan2.nextLine();
                    		
                		}
                		else {
                			imagen="-";
                		}
                		
                		System.out.printf("Desea introducir un archivo de audio?\n");
                		confirmacion = scan2.nextLine();
                		
                		String audio = "";
                		
                		if ( confirmacion.equals("si") || confirmacion.equals("Si") ) {
                			
                			System.out.printf("Introduzca nombre del audio de la carpeta AUDIOS: \n");
                    		audio = scan2.nextLine();
                			
                		}
                		else {
                			audio="-";
                		}
                		
                		
                		String lineanueva = nombre + ":" + comp + ":" + nivel + ":" + armad+ ":" + compases + ":" + imagen + ":" + audio + ":";
                		writer.write(lineanueva + "\n");
                		
                		continue; // Saltamos a la siguiente linea
                		    	
        		    }
        		    
        		    if(linea != null) {
        		    	writer.write(linea + "\n");
        		    }
        		}
        		
        		writer.close();
        		br.close();
        		
        		// Eliminamos la biblioteca antigua
        		biblioteca.delete();
        		
        		// Renombramos la copia como la nueva biblioteca
        		File newFile = new File(bibliocopia2.getParent(), "biblioteca.txt");
        		Files.move(bibliocopia2.toPath(), newFile.toPath());
        		
        		}
        	
        	else if (opcion == 3) { // Listar todas las piezas
        		
        		System.out.printf("\nLista de todas las piezas:\n");
        		
        		File biblioteca = new File ("biblioteca.txt");
        		FileReader fr = new FileReader (biblioteca);
        		BufferedReader br = new BufferedReader(fr);
        		
        		// Leemos y mostramos todas las lineas de la biblioteca
        		String linea = br.readLine();
        		int i = 1;
        		
        		while(linea != null) {
        			
        			String[] separada = linea.split(":"); // Separamos la linea en los datos para mostrarlos
        			
        			System.out.printf("\n***Pieza numero %d***\n", i);
        			
        			System.out.printf("Nombre: %s\n", separada[0] );
        			System.out.printf("Compositor: %s\n", separada[1] );
        			System.out.printf("Nivel: %s\n", separada[2] );
        			System.out.printf("Armadura: %s\n", separada[3] );        			
        			System.out.printf("Compases: %s\n", separada[4] );
        			System.out.printf("Imagen: %s\n", separada[5] );
        			System.out.printf("Audio: %s\n", separada[6] );
        			
        			linea = br.readLine();
        			i++;
        		}
        		
        		System.out.printf("\n***Final de la biblioteca***\n");
        		
        	}
        	else if (opcion == 4) { // Mostrar una sola pieza
        		
        		// Usuario introduce numero de pieza para mostrar
        		System.out.printf("\nIntroduzca numero de pieza a mostrar:\n");
        		int lineamostrar = scan.nextInt();
        		
        		File biblioteca = new File ("biblioteca.txt");
        		FileReader fr = new FileReader (biblioteca);
        		BufferedReader br = new BufferedReader(fr);
        		
        		// Leemos todas las lineas de la biblioteca y mostramos la indicada
        		String linea = br.readLine();
        		int i = 1;
        		
        		while(linea != null) {
        			
        			if (i == lineamostrar) {
        				
        				String[] separada = linea.split(":");
            			
            			System.out.printf("\n***Pieza numero %d***\n", i);
            			
            			System.out.printf("Nombre: %s\n", separada[0] );
            			System.out.printf("Compositor: %s\n", separada[1] );
            			System.out.printf("Nivel: %s\n", separada[2] );
            			System.out.printf("Armadura: %s\n", separada[3] );        			
            			System.out.printf("Compases: %s\n", separada[4] );
            			System.out.printf("Imagen: %s\n", separada[5] );
            			System.out.printf("Audio: %s\n", separada[6] );
            			
            			// Activamos la imagen de la pieza si existe
            			if ( !separada[5].equals("-") ) {

                			String imagen_file = "FOTOS/" + separada[5] + ".png";
                	        frame.getContentPane().add(new JLabel(new ImageIcon(imagen_file)));
                	        frame.setVisible(true);
            			}
            			
            			// Reproducimos el audio de la pieza si existe
            			if ( !separada[6].equals("-") ) {

                			//Reproducir audio
            				try {
            		            
            					// CON .wav
            		            String audioWAV = "AUDIOS/" + separada[6] + ".wav";
            		            
            		            File f = new File(audioWAV);
            		            
            		            if ( f.exists() ) {
            		            	
            		            	Clip sonido = AudioSystem.getClip();
                		            sonido.open(AudioSystem.getAudioInputStream(new File(audioWAV)));
                		            sonido.start();
                		            
                		            System.out.print("Pulse una tecla para detener el audio:\n");
                		            scan2.nextLine();
                		            sonido.close();
            		            	
            		            }
            		            else {
            		            	
            		            	// CON .mp3
                					String audioMP3 = "AUDIOS/" + separada[6] + ".mp3";
                					
                					AdvancedPlayer apl = new AdvancedPlayer( new FileInputStream(audioMP3) );
                				    apl.play(1, 350); // Se reproducen 350 frames de sonido
            		            	
            		            }
            		            
            		        } catch (Exception e) {
            		            System.out.println("" + e);
            		        }
            			}
            			
        			}
        			
        			linea = br.readLine();
        			i++;
        		}
        		
        	}
        	else if (opcion == 5) { // Eliminar una pieza
        		
        		// Usuario introduce numero de linea para borrar
        		System.out.printf("Introduzca numero de la pieza que quiere borrar: \n");
        		int lineaborrar = scan.nextInt();
        		
        		// Guardamos lineas buenas en otro fichero copia (la mala no se guarda)
        		File biblioteca = new File("biblioteca.txt");
        		File bibliocopia = new File("bibliocopia.txt");

        		BufferedReader br = new BufferedReader(new FileReader(biblioteca));
        		BufferedWriter writer = new BufferedWriter(new FileWriter(bibliocopia));
        		
        		String linea = "";
        		int i = 0;
        		
        		while( linea != null) {
        			
        			i++;
        			linea = br.readLine();
        			
        		    if( i == lineaborrar ) { // Cuando lleguemos a la linea indicada, saltamos a la siguiente sin guardarla
        		    	continue;
        		    }
        		    
        		    if(linea != null) {
        		    	writer.write(linea + "\n");
        		    }
        		}
        		
        		writer.close();
        		br.close();
        		
        		// Eliminamos la biblioteca antigua
        		biblioteca.delete();
        		
        		// Renombramos la copia como la nueva biblioteca
        		File newFile = new File(bibliocopia.getParent(), "biblioteca.txt");
        		Files.move(bibliocopia.toPath(), newFile.toPath());
        		        		
        	}
        	
        }
        System.out.printf("\nGracias por usar la biblioteca musical. Hasta pronto!\n");
        System.exit(0);

    }
}   
  
        
