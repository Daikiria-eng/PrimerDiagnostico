package ppal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * Desde esta clase se invocaran los comandos de diagnóstico para el
 * usuario
 * 
 * @author enikyasta
 */
public class comandos {
    /**
     * Retorna la información del sistema, según el output del comando
     * de systeminfo
     * 
     * @return output
     */
    public String sysinfo(){
        String output="";
        try{
            System.out.println("[*] Obteniendo información");
            Process proces=Runtime.getRuntime().exec("systeminfo");
            BufferedReader br=new BufferedReader(new InputStreamReader(proces.getInputStream()));
            for(int i=0;i<7;i++){
                output+=br.readLine()+"\n";
            }
        }catch(IOException ioe){
            System.out.println("[-] Error al obtener informacion:\n"+ioe);
            ioe.printStackTrace();
        }
        return output;
    }
    
    /**
     * 
     * Se realiza un chequeo del disco y se retorna el output de la 
     * ejecución del comando 
     * 
     * @return 
     */
    public String chequearDisco(){
        String output="";
        try {
            Process proc=Runtime.getRuntime().exec("cmd /c chkdsk > resultado.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String temp="";
            
        } catch (IOException ioe) {
            System.out.println("[-] Error chequeando disco");
            ioe.printStackTrace();
        }
        return output;
    }

    /**
     *
     * Este método se encargará de crear un carpeta de temporales
     * en caso de que no existe
     */
    public boolean carpeta_temporal(){
        try{
            Process proces=Runtime.getRuntime().exec("cmd /c "+commandConstants.MK_TEMP);
            return true;
        }catch(Exception e){
            System.out.println("[-] Error al crear carpeta temporal");
            e.printStackTrace();
        }
        return false;
    }
}
