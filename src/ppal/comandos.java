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
        try{
            Process proces=Runtime.getRuntime().exec("cmd /c chkdsk");
            BufferedReader br=new BufferedReader(new InputStreamReader(proces.getInputStream()));
            String temp="",
                   resx=commandConstants.TEMP_DIR+"resultado.txt";
            while(true){
                temp=br.readLine();
                if(temp==null) break;
                else output+=temp+"\n";
            }
            try{
                if(carpeta_temporal()){
                    File restxt=new File(resx);
                    FileWriter fw=new FileWriter(restxt);
                    BufferedWriter bw=new BufferedWriter(fw);
                    bw.write(output);
                    bw.close();
                }else
                    System.out.println("[-] No se pudo crear temp/resultados.txt");
            }catch(Exception e){
                System.out.println("[+] Error al escribir output");
                e.printStackTrace();
            }
            try {
                Process awk_filter=Runtime.getRuntime().exec(
                        "cmd /c "+commandConstants.AWK+" '/problem/ {print}' "+resx
                );
                BufferedReader be=new BufferedReader(new InputStreamReader(proces.getInputStream()));
                String temp_br="";
                output="";
                while(true){
                    temp_br=br.readLine();
                    if(temp_br==null) break;
                    else output+=temp_br;
                }
                return output;
            } catch (IOException ioe) {
                System.out.println("[-] Error al generar registro");
                ioe.printStackTrace();
            }
        }catch(IOException ioe){
            System.out.println("[-] Error al chequear disco:\n");
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
