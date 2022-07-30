package ppal;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;

/**
 *
 * Método principal donde se renderiza el programa
 * 
 * @author enikyasta
 */
public class principal extends JFrame{
    /**
     * 
     * Método principal de impresión
     * @param args 
     */
    public static void main(String[]args) {
        primeraVentana pv=new primeraVentana();
        pv.setVisible(true);
        //segundaClase sv=new segundaClase();
        //sv.setVisible(true);
        /*File test=new File("batch/ejemplo.sh");
        try{
            System.out.println("[*] Ejecutando");
            Process proces=Runtime.getRuntime().exec("/bin/bash "+test.toPath());
            BufferedReader br=new BufferedReader(new InputStreamReader(proces.getInputStream()));
            String output="";
            while((output=br.readLine())!=null)
                System.out.println(output);
        }catch(IOException ioe){
            System.out.println("[-] Error al ejecutar comando:\n");
            ioe.printStackTrace();
        }*/
    }
}
