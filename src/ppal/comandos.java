package ppal;

import java.io.BufferedReader;
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
            String temp="";
            while(true){
                temp=br.readLine();
                System.out.println(temp);
                if(temp==null) break;
                else output+=temp+"\n";
            }
        }catch(IOException ioe){
            System.out.println("[-] Error al obtener informacion:\n"+ioe);
            ioe.printStackTrace();
        }
        System.out.println("retorno");
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
        try{
            System.out.println("[*] Chequeando disco");
            Process proces=Runtime.getRuntime().exec("chkdsk");
            BufferedReader br=new BufferedReader(new InputStreamReader(proces.getInputStream()));
            String temp="";
            while(true){
                temp=br.readLine();
                if(temp==null) break;
                else{
                    System.out.println(temp);
                    output+=temp+"\n";
                }
            }
        }catch(IOException ioe){
            System.out.println("[-] Error al chequear disco:\n");
            ioe.printStackTrace();
        }
        System.out.println("checkpoint retorno");
        return output;
    }
}