package ppal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;

/**
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

        try{
            Process proces=Runtime.getRuntime().exec("echo 'Prueba'");
            BufferedReader br=new BufferedReader(new InputStreamReader(proces.getInputStream()));
            String output=null;
            while((output=br.readLine())!=null){
                System.out.println(output);
            }
        }catch(IOException ioe){
            System.out.println("Error al ejecutar el comando: "+ioe);
            ioe.printStackTrace();
        }
    }

}
