/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Alexis
 */
public class EvaluadorPassword {
    
    private static final double PC_DOMESTICA = 100_000_000.0;
    private static final double CLUSTER_HACKER = 100_000_000_000.0;
    // MAYUSCULAS
    public static boolean isMayus(String str){
        for(int i = 0; i < str.length(); i++){
            if(Character.isUpperCase(str.charAt(i))) return true;
        }
        return false;
    }
    // MINUSCULAS
    public static boolean isMinus(String str){
         for(int i = 0; i < str.length(); i++){
            if(Character.isLowerCase(str.charAt(i))) return true;
        }
        return false;
    }
    // Numeros 
    public static boolean isNumer(String str){
          for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))) return true;
        }
        return false;
    }
    // SIGNOS
    public static boolean isSigne(String str){
        return Pattern.compile("[^a-zA-Z0-9]").matcher(str).find();
    }
    // TAMAÑO mayor a 12
    public static boolean isLengh(String str) {
        return str.length() >= 12;
    }
    // EVITAR SECUENCIAS 123 || 321
    
    // ENVITAR NOMBRES
    
    // TIEMPO DE ROTURA
    
public static String tiempoRotura(String contrasena, int tiempo) {
    if (contrasena == null || contrasena.isEmpty()) return "0";

    int caracteres = 0;

    if (isMinus(contrasena)) caracteres += 26;
    if (isMayus(contrasena)) caracteres += 26;
    if (isNumer(contrasena)) caracteres += 10;
    if (isSigne(contrasena)) caracteres += 32;

    // Combinaciones posibles según longitud y caracteres
    double combinaciones = Math.pow(caracteres, contrasena.length());

    // Tiempo medio para encontrar la contraseña
    double intentosNecesarios = combinaciones / 2.0;
    double segundos = intentosNecesarios / CLUSTER_HACKER;

    if (segundos < 60) return segundos + " seg";

    double min = segundos / 60;
    if (min < 60) return min + " min";

    double horas = min / 60;
    if (horas < 24) return horas + " horas";

    double dias = horas / 24;
    if (dias < 365) return dias + " días";

    double anos = dias / 365;
    return anos + " años";
}

    
    
    public static ArrayList<String> EvaluadorPassword(String contrasena, String nombre) {

        int total = 0;
        ArrayList<String> e = new ArrayList<>();

        if (isMayus(contrasena)) total += 26;
        if (isMinus(contrasena)) total += 26;
        if (isNumer(contrasena)) total += 10;
        if (isSigne(contrasena)) total += 32;
        if (isLengh(contrasena)) total += 20;
        if(contrasena.equals(nombre) || contrasena.contains(nombre)) total -= 30;
        
        System.out.println(total);
        System.out.println(contrasena);

        e.add("" + total);
        e.add(tiempoRotura(contrasena, total));

        return e;
    }
}

