/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author daniel
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;
    private String[] operandos = new String[3];
    private static int contador;
    private static String operador;

    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
        contador=0;
    }

    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);
        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        // Si es un botón
        if (o instanceof JButton) {
            areaTexto.setText(operandos[0] + operandos[1] + operandos[2]);
            String dato = ((JButton) o).getText();
            if (contador > 2) {
                contador = 0;
            }

            if(dato.equalsIgnoreCase("=")&&operandos[0]!=null&&operandos[1]!=null&&operandos[2]!=null){
                
            areaTexto.setText("haz la cuenta!");
            }
            if (dato.equalsIgnoreCase("c")){
                operandos[0]=null;
                operandos[1]=null;
                operandos[2]=null;
                areaTexto.setText(operandos[0] + operandos[1] + operandos[2]);
                contador=0;
            }
            
            switch (contador) {
                case 0:
                    if(dato.matches("[0-9]")){
                        operandos[0] = dato;
                        areaTexto.setText(operandos[0] + operandos[1] + operandos[2]);
                        
                    }else{
                        contador--;
                    }
                    
                    break;
                case 1:
                    if(dato.equalsIgnoreCase("+")||dato.equalsIgnoreCase("-")
                            ||dato.equalsIgnoreCase("/")||dato.equalsIgnoreCase("*")){
                        operandos[1] = dato;
                        areaTexto.setText(operandos[0] + operandos[1] + operandos[2]);
                        
                    }else{
                        contador--;
                    }
                    
                    break;
                case 2:
                    if(dato.matches("[0-9]")){
                        operandos[2] = dato;
                        areaTexto.setText(operandos[0] + operandos[1] + operandos[2]);
                        
                    }else{
                        contador--;
                    }
                    break;
            }
            

        }

        
        contador++;

    }
    
    
}


