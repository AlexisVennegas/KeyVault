package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alexis
 */
public class VaultDAO {

    private static FileReader fr;
    private static BufferedReader br;
    static ArrayList<RegistroPassword> registros = new ArrayList<RegistroPassword>();

    public static ArrayList<RegistroPassword> leer() {
        try {
            File archivo = new File(
                    "C:\\Users\\Alexis\\Documents\\NetBeansProjects\\KeyVault\\src\\main\\webapp\\WEB-INF\\vault.txt"
            );
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea = null;
            String[] tokensLinea = null;

            String nombre;
            String contraseña;
            String fecha;
            String nivelfortaleza;

            RegistroPassword registro;
            linea = br.readLine();
            while (linea != null) {
                tokensLinea = linea.split(",");
                registro = new RegistroPassword(
                        tokensLinea[1], // clave
                        tokensLinea[3], // nivel 
                        tokensLinea[2], // fecha
                        tokensLinea[0] // nombre

                );
                registros.add(registro);

                linea = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registros;
    }

    public static void guardar(RegistroPassword datos) throws IOException {

        try {
            File archivo = new File(
                    "C:\\Users\\Alexis\\Documents\\NetBeansProjects\\KeyVault\\src\\main\\webapp\\WEB-INF\\vault.txt"
            );

            FileWriter fw = new FileWriter(archivo, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(
                    datos.getNombre() + ","
                    + datos.getClave() + ","
                    + datos.getFecha() + ","
                    + datos.getNivelfortaleza());
            pw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
}
