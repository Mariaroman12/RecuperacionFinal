package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import data.ControladorFichero;


public class GestorJSON {

    public static boolean cargarSensor(Artefacto art, String jsonfile) {
        if (!jsonfile.isBlank()) {
            try {
                Gson gson = new Gson();
                String json = ControladorFichero.readText(jsonfile + ".json");
                Sensor sensor = gson.fromJson(json, Sensor.class);
                art.añadirSensores(sensor);
                return true;
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            System.out.println("Operación cancelada.");
            return false;
        }
    }
    
    

    public static boolean grabarSensor(Sensor sen, String jsonfile) {
        if (!jsonfile.isBlank()) {
            try {
                Gson gson = new Gson();
                String dataJson = gson.toJson(sen);
                ControladorFichero.writeText(jsonfile + ".json", dataJson, true);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
    
    
    public static boolean grabarArtefacto(Artefacto art, String jsonfile) {
        if (!jsonfile.isBlank()) {
            try {
                Gson gson = new Gson();
                String dataJson = gson.toJson(art);
                ControladorFichero.writeText(jsonfile + ".json", dataJson, true);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean cargarArtefacto(Map<Integer, Artefacto> destino, String jsonfile) {
        if (!jsonfile.isBlank()) {
            try {
                Gson gson = new Gson();
                String json = ControladorFichero.readText(jsonfile + ".json");
                Artefacto art = gson.fromJson(json, Artefacto.class);
                destino.put(art.getProductID(), art);
                return true;
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            System.out.println("Operación cancelada.");
            return false;
        }
    }
}


