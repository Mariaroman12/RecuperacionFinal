package vista;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;
import data.ControladorFichero;
import modelo.Artefacto;
import modelo.Campo;
import modelo.GestorJSON;
import modelo.Sensor;

public class Main {
	
	//C:\proyectos\artefactoo
	//C:\proyectos\campo
	//C:\proyectos\sensor
	//C:\proyectos\guardar.txt
	
	private static Map<Integer,Artefacto> artefactos = new HashMap<>();
	private static GestorJSON GestorJSON = new GestorJSON();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        String respuesta;
        boolean bContinuarMenu = true;

        do {
        	
            System.out.println("Menú de Opciones");
            System.out.println("------------------------");
            System.out.println("A: Añadir Artefacto");
            System.out.println("B: Añadir sensor al artefacto");
            System.out.println("C: Borrar Sensor al artefacto");
            System.out.println("D: Añadir campo al sensor");
            System.out.println("E: Borrar campo del sensor");
            System.out.println("F: Grabar a JSON Artefacto");
            System.out.println("G: Grabar a JSON Sensor");
            System.out.println("Cualquier otra cosa: Salir");

            respuesta = sc.nextLine();

            if (respuesta.compareToIgnoreCase("A") == 0) {
            		
                System.out.println("Introduce el nombre del fichero JSON para cargar el artefacto:");
                String filename = sc.nextLine();
                
                if (GestorJSON.cargarArtefacto(artefactos, filename)) {
                    System.out.println("¡Artefacto cargado con éxito!");
                }else {
                    System.out.println("Error al cargar el artefacto.");
                }
                
            	
            } else if(respuesta.compareToIgnoreCase("B") == 0) {
            	
            	System.out.println("Introduce el nombre del fichero JSON para cargar el sensor:");
                String filename = sc.nextLine();
                System.out.println("Introduce el código del artefacto:");
                int codigoArtB = Integer.valueOf(sc.nextLine());
                if (artefactos.containsKey(codigoArtB)) {
                    if (GestorJSON.cargarSensor(artefactos.get(codigoArtB), filename)) {
                        System.out.println("¡Sensor añadido con ex");
                    }else {
                        System.out.println("No se ha podido añadir");
                    }
                }else {
                    System.out.println("Artefacto no encontrado");
                }
              
            		
            } else if (respuesta.compareToIgnoreCase("C") == 0) {
                
                System.out.println("Introduce el código del artefacto:");
                int codigoArtC = Integer.valueOf(sc.nextLine());
                System.out.println("Introduce el número del sensor:");
                String numSensorC = sc.nextLine();
                if (artefactos.containsKey(codigoArtC)) {
                    Artefacto artefactoC = artefactos.get(codigoArtC);
                    Sensor sensorC = artefactoC.buscarSensor(numSensorC);
                    if (sensorC != null && artefactoC.eliminarSensor(numSensorC)) {
                        System.out.println("¡Sensor borrado con exito");
                  }else {
                      System.out.println("Sensor no encontrado.");
                  			}
                }else{
                    System.out.println("Artefacto no encontrado.");
                		}
                
            } else if (respuesta.compareToIgnoreCase("D") == 0) {
            	System.out.println("Introduce el código del artefacto");
                int codigoArt = Integer.valueOf(sc.nextLine());
                System.out.println("Introduce el número del sensor");
                String numSensor = sc.nextLine();
                if (artefactos.containsKey(codigoArt)) {
                    Artefacto artefacto = artefactos.get(codigoArt);
                    Sensor sensor = artefacto.buscarSensor(numSensor);
                    if (sensor != null) {
                        System.out.println("Introduce el nombre del campo");
                        String nameC = sc.nextLine();
                        System.out.println("Introduce la unit del campo");
                        String unit = sc.nextLine();
                        float decPrecision = leerFloat("Introduce la decprec", sc);
                        Campo campo = new Campo(nameC, unit, decPrecision);
                        if (sensor.addCampo(campo)) {
                            System.out.println("¡Campo añadido con exi");
                        } else {
                            System.out.println("Error al añadir el campo");
                        }
                    }else {
                        System.out.println("Sensor no encontrado");
                    }
                }else {
                    System.out.println("Artefacto no encontrado");
                }
                	
            } else if (respuesta.compareToIgnoreCase("E") == 0) {
            	System.out.println("Introduce el código del artefacto");
                int codigoArtE = Integer.valueOf(sc.nextLine());
                System.out.println("Introduce el número del sensor");
                String numSensorE = sc.nextLine();
                if (artefactos.containsKey(codigoArtE)) {
                    Artefacto artefactoE = artefactos.get(codigoArtE);
                    Sensor sensorE = artefactoE.buscarSensor(numSensorE);
                    if (sensorE != null) {
                        System.out.println("Introduce el nombre del campo q quieres eliminar");
                        String nombreCampoE = sc.nextLine();
                        if (sensorE.eliminarCampo(nombreCampoE)) {
                            System.out.println("¡Campo eliminado bien");
                        }else {
                            System.out.println("Error al eliminar el campo");
                        }
                    }else {
                        System.out.println("Sensor no encontrado");
                    }
                }else {
                    System.out.println("Artefacto no encontrado");
                }
                	
            } else if (respuesta.compareToIgnoreCase("F") == 0) {
            	System.out.println("Introduce el nombre del fichero para guardar el artefacto");
                String fileF = sc.nextLine();
                System.out.println("Introduce el código del artefacto");
                int codArtF = Integer.parseInt(sc.nextLine());

                Artefacto artefactoF = artefactos.get(codArtF);
                if (artefactoF != null) {
                    if (GestorJSON.grabarArtefacto(artefactoF, fileF)) {
                        System.out.println("Artefacto grabado con éxito.");
                    } else {
                        System.out.println("Error al grabar el artefacto.");
                    }
                } else {
                    System.out.println("El artefacto no se ha encontrado.");
                }
            
                
              }else if (respuesta.compareToIgnoreCase("G") == 0) {
            	System.out.println("Introduce el nombre del fichero para guardar el sensor");
                    String filename = sc.nextLine();
                    System.out.println("Introduce el cod del artefacto:");
                    int codArt = Integer.valueOf(sc.nextLine());
                    System.out.println("Introduce el num del sensor");
                    String numSens = sc.nextLine();

                    Artefacto artefactoG = artefactos.get(codArt);
                    if (artefactoG != null) {
                        Sensor sensorG = artefactoG.buscarSensor(numSens);
                        if (sensorG != null) {
                            if (GestorJSON.grabarSensor(sensorG, filename)) {
                                System.out.println("Sensor grabado con éxito.");
                            }else {
                                System.out.println("Error al grabar el sensor.");
                            }
                        }else {
                            System.out.println("El sensor no se ha encontrado.");
                        }
                    }else {
                        System.out.println("El artefacto no se ha encontrado.");
                    }
                		
            } else {
                	
                bContinuarMenu = false;
                	
            }
            
            if (bContinuarMenu) {
            	
            	System.out.println("Pulse ENTER para continuar");
        		respuesta = sc.nextLine();
            	
            }
            	
        } while (bContinuarMenu);
        
        sc.close();

	}
	
	public static float leerFloat(String s, Scanner sc) {
		boolean repetir;
		float n = 0;
		do {
			repetir = false;
			try {
				System.out.println(s);
				n = sc.nextFloat();
			} catch (InputMismatchException e) {
				System.out.println("Error al guardar el número");
				repetir = true;
			} finally {
				sc.nextLine();
			}
		} while (repetir);
		return n;
	}
	
}
