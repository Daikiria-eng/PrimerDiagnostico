package ppal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;


/**
 *
 * @author enikyasta
 */
public class primeraVentana extends JFrame{
    public primeraVentana(){
        setTitle("Menú principal");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new DimensionUIResource(600,500));
        menu_ppal();
    }

    /**
     *
     * Se establecen las propiedades del panel de la aplicación
     *
     * @return tapiz
     */
    public JPanel tapiz(){
        JPanel tapiz=new JPanel();
        tapiz.setBackground(Color.lightGray);
        tapiz.setLayout(null);
        this.getContentPane().add(tapiz);
        return tapiz;
    }

    /**
     *
     * Se crea la pantalla principal donde está en menú
     */
    public void menu_ppal(){
        setLocationRelativeTo(null);
        JPanel tapiz_local=tapiz();
        JLabel titulo=new JLabel();
        titulo.setText("Primer Diagnóstico");
        titulo.setBounds(100,50,400,40);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setMaximumSize(new DimensionUIResource(268,60));
        titulo.setFont(new Font("Serif", Font.BOLD, 30));
        tapiz_local.add(titulo);

        JButton utilidades=new JButton("Utilidades");
        utilidades.setBounds(180,140,250,40);
        utilidades.setHorizontalAlignment(SwingConstants.CENTER);
        utilidades.setBackground(Color.WHITE);
        utilidades.setEnabled(true);
        tapiz_local.add(utilidades);

        JButton comando=new JButton("Comando personalizado");
        comando.setBounds(180,200,250,40);
        comando.setHorizontalAlignment(SwingConstants.CENTER);
        comando.setBackground(Color.WHITE);
        comando.setMaximumSize(new DimensionUIResource(268,60));
        ActionListener click=(ActionEvent e) -> {
            if(e.getSource()==comando){
                tapiz_local.removeAll();
                comando_personalizado(tapiz_local);
            }else{
                utilidades();
                setMinimumSize(new DimensionUIResource(1100,600));
            }
        };
        comando.addActionListener(click);
        utilidades.addActionListener(click);

        tapiz_local.add(comando);
    }

    /**
     *
     * Este es el pantallazo dondel usuario ejecuta un comando personalizado
     *
     * Recibe como parámetro el papel fondo de la aplicación de la clase
     *
     * @param tapiz_local 
     */
    public void comando_personalizado(JPanel tapiz_local){
        setLocationRelativeTo(null);
        JLabel titulo=new JLabel();
        titulo.setText("Comando personalizado");
        titulo.setBounds(20,50,600,40);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);       
        titulo.setFont(new Font("Serif", Font.BOLD, 30));
        tapiz_local.add(titulo);

        JTextField comando=new JTextField("Su comando");
        comando.setBounds(60,140,500,35);
        tapiz_local.add(comando);
    }

    /**
     *
     * Esta es la pantalla donde los usuarios disponen de sus opciones
     * para diagnóstico de la máquina
     *
     */
    public void utilidades(){
        setLocationRelativeTo(null);
        this.getContentPane().removeAll();
        this.getContentPane().setBackground(Color.BLACK);
        JPanel izq=new JPanel(),
            titulo_p=new JPanel(),
            der=new JPanel();
        
        titulo_p.setBackground(Color.lightGray);
        
        der.setBackground(Color.lightGray);
        //der.setLayout(null);
        
        izq.setBackground(Color.BLUE);
        izq.setLayout(new BoxLayout(izq,BoxLayout.Y_AXIS));

        this.getContentPane().add(titulo_p,BorderLayout.NORTH);
        this.getContentPane().add(der,BorderLayout.EAST);
        this.getContentPane().add(izq,BorderLayout.WEST);

        JLabel titulo=new JLabel();
        
        titulo.setText("Utilidades de usuario");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 30));
        titulo_p.add(titulo);
        
        JButton sysinfo=new JButton("Información del sistema"),
            chkdsk=new JButton("Chequear disco");

        sysinfo.setBackground(Color.WHITE);
        izq.add(sysinfo);

        chkdsk.setBackground(Color.WHITE);
        izq.add(chkdsk);
        
        JTextArea output_field=new JTextArea();
        String output=null;
        try{
            Process proces=Runtime.getRuntime().exec("uname -a");
            BufferedReader br=new BufferedReader(new InputStreamReader(proces.getInputStream()));
            while(br.readLine()!=null){
                output=br.readLine();
            }
        }catch (IOException ioe){
            System.out.println("[-] Error al ejecutar el comando");
            ioe.printStackTrace();
        }
        output_field.setSize(600,600);
        output_field.setLocation(700,700);
        System.out.println("[?] Imprimiendo output:\n"+output);
        output_field.setText(output);
        output_field.setEnabled(false);
        der.add(output_field);
    }
}