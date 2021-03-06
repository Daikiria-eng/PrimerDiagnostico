package ppal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        ActionListener click=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==comando){ 
                    tapiz_local.removeAll();
                    comando_personalizado(tapiz_local);
                }else{
                    tapiz_local.removeAll();
                    utilidades(tapiz_local);
                    setMinimumSize(new DimensionUIResource(1100,600));
                }
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
     * @param tapiz_local 
     */
    public void utilidades(JPanel tapiz_local){
        JLabel titulo=new JLabel();
        titulo.setText("Utilidades de usuario");
        titulo.setBounds(20,50,600,40);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 30));
        tapiz_local.add(titulo,BorderLayout.WEST);

        JButton sysinfo=new JButton("Información del sistema");
    }
}
