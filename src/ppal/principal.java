package ppal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    public static void main(String[]args) throws FileNotFoundException, IOException {
        primeraVentana pv=new primeraVentana();
        pv.setVisible(true);
    }
}
