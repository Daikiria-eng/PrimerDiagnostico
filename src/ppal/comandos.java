package ppal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author enikyasta
 */
public class comandos {
    public String sysinfo(){
        String output="";
        try{
            Process proces=Runtime.getRuntime().exec("systeminfo");
            BufferedReader br=new BufferedReader(new InputStreamReader(proces.getInputStream()));
            while(true){
                String temp=br.readLine()+"\n";
                if(temp==null) break;
                output+=temp;
            }
        }catch(IOException ioe){
            System.out.println("[-] Error al obtener informacion:\n"+ioe);
            ioe.printStackTrace();
        }
        return output;
    }
    
    public String chequearDisco(){
        String output="";
        try{
            Process proces=Runtime.getRuntime().exec("chksdk");
            BufferedReader br=new BufferedReader(new InputStreamReader(proces.getInputStream()));
            while(true){
                String temp=br.readLine();
                if(temp==null) break;
                output+=temp+"\n";
            }
        }catch(IOException ioe){
            System.out.println("[-] Error al chequear disco:\n");
            ioe.printStackTrace();
        }
        return output;
    }
}