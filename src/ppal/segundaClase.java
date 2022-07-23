package ppal;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.plaf.DimensionUIResource;

/**
 *
 * @author enikyasta
 */
public class segundaClase extends JFrame{
    public segundaClase(){
        setTitle("Prueba");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new DimensionUIResource(600,500));
        inicComponentes();
    }
    
    public void inicComponentes(){
        JPanel bg=new JPanel(),
                sg=new JPanel(),
                onein=new JPanel();
        onein.setBackground(Color.GREEN);
        bg.setBackground(Color.RED);
        bg.setSize(70,200);
        sg.setBackground(Color.BLUE);
        sg.add(onein);
        //bg.setLayout(null);
        this.getContentPane().add(bg);
        //this.getContentPane().add(bg,BorderLayout.WEST);
        this.getContentPane().add(sg,BorderLayout.EAST);
        this.getContentPane().setBackground(Color.BLACK);
        
        JLabel txt=new JLabel("Etiqueta");
        JTextArea jta=new JTextArea("COntenido");
        bg.add(jta);
        jta.append("sdfasdf");
        
        
        txt.setBounds(100,100,100,100);
        bg.add(txt);
        JButton boton =new JButton("Botón inútil");
        System.out.println(boton.getBounds());
        bg.add(boton);
        JLabel txt2=new JLabel("Segunda Etiqueta");
        onein.add(txt2);
    }
}