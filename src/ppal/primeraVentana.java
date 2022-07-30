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
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;

/**
 *
 * @author enikyasta
 */
public class primeraVentana extends JFrame{
    public primeraVentana(){
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
        setTitle("Menu principal");

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
            if(e.getSource()==comando)
                comando_personalizado();
            else
                utilidades();
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
     */
    public void comando_personalizado(){
        setTitle("Comando Personalizado");
        setMaximumSize(new DimensionUIResource(1000,1050));

        this.getContentPane().removeAll();
        JPanel tapiz_local=new JPanel();
        tapiz_local.setBackground(Color.lightGray);
        tapiz_local.setLayout(null);
        this.getContentPane().add(tapiz_local);

        JLabel titulo=new JLabel();
        titulo.setText("Comando personalizado");
        titulo.setFont(new Font("Serif", Font.BOLD, 30));
        titulo.setBounds(20,50,600,40);
        tapiz_local.add(titulo);

        JTextField comando=new JTextField();
        comando.setText("Ingrese su comando personalizado");
        comando.setBounds(60,140,500,35);
        tapiz_local.add(comando);

        JTextArea output_field=new JTextArea();
        output_field.setText("Resultado del comando");
        output_field.setBounds(60,300,500,200);
        output_field.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        output_field.setEnabled(false);
        output_field.setBackground(Color.WHITE);
        output_field.setForeground(Color.BLACK);
        tapiz_local.add(output_field);

        JButton ejecutar=new JButton("Ejecutar comando"),
            menu_ppal_b=new JButton("Ir al menú ppal");
        ejecutar.setBounds(170,200,250,30);
        ejecutar.setBackground(Color.WHITE);
        ejecutar.setFont(new Font("Serif",Font.BOLD,15));

        menu_ppal_b.setBounds(195,245,200,30);
        menu_ppal_b.setFont(new Font("Serif",Font.BOLD,15));
        menu_ppal_b.setBackground(Color.WHITE);

        ActionListener click=(ActionEvent ae)->{
            if(ae.getSource()==ejecutar){
                String cmd=comando.getText(),
                        output="";
                try{
                    Process proces=Runtime.getRuntime().exec(cmd);
                    BufferedReader br=new BufferedReader(new InputStreamReader(proces.getInputStream()));
                    output_field.setText("");
                    while((output=br.readLine())!=null)
                        output_field.append(output+"\n");
                }catch(IOException ioe){
                    System.out.println("[-] Error al ejecutar el comando:\n");
                    ioe.printStackTrace();
                    output_field.setText("Por favor verifique su comando");
                }
            }else if(ae.getSource()==menu_ppal_b){
                this.getContentPane().removeAll();
                menu_ppal();
            }
        };

        ejecutar.addActionListener(click);
        menu_ppal_b.addActionListener(click);

        tapiz_local.add(ejecutar);
        tapiz_local.add(menu_ppal_b);
    }

    /**
     *
     * Esta es la pantalla donde los usuarios disponen de sus opciones
     * para diagnóstico de la máquina
     *
     */
    public void utilidades(){
        setMaximumSize(new DimensionUIResource(1000,600));
        setTitle("Utilidades del usuario");

        comandos cmds=new comandos();
        setLocationRelativeTo(null);
        setMaximumSize(new DimensionUIResource(1000,600));
        this.getContentPane().removeAll();
        this.getContentPane().setBackground(Color.lightGray);
        JPanel izq=new JPanel(),
            titulo_p=new JPanel(),
            der=new JPanel();

        titulo_p.setBackground(Color.lightGray);

        der.setBackground(Color.lightGray);

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
            chkdsk=new JButton("Chequear disco"),
            menu=new JButton("Volver al menu");

        sysinfo.setBackground(Color.WHITE);
        izq.add(sysinfo);
        chkdsk.setBackground(Color.WHITE);
        izq.add(chkdsk);
        menu.setBackground(Color.WHITE);
        izq.add(menu);

        JTextPane output_field=new JTextPane();
        output_field.setSize(600,600);
        output_field.setLocation(700,700);
        //output_field.setEnabled(false);
        output_field.setBackground(Color.lightGray);
        output_field.setFont(new Font(Font.MONOSPACED,Font.PLAIN,19));
        output_field.setForeground(Color.BLACK);
        output_field.setText("Salida de los comandos");
        der.add(output_field);

        ActionListener click=(ActionEvent ae)->{
            if(ae.getSource()==menu){
                getContentPane().removeAll();
                menu_ppal();
            }if(ae.getSource()==sysinfo){
                output_field.removeAll();
                output_field.setText(cmds.sysinfo());
            }if(ae.getSource()==chkdsk){
                output_field.removeAll();
                output_field.setText(cmds.chequearDisco());
            }
        };
        sysinfo.addActionListener(click);
        chkdsk.addActionListener(click);
        menu.addActionListener(click);
    }
}
