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
            
            String dato = ((JButton) o).getText();
            if (contador > 2) {
                contador = 0;
            }

            if(dato.equalsIgnoreCase("=")&&operandos[0]!=null&&operandos[1]!=null&&operandos[2]!=null){
                
            hacerCuenta();
            presionarC();
            }
            if (dato.equalsIgnoreCase("c")){
               presionarC();
               mostrarTexto();
            }
            
            
            
            switch (contador) {
                case 0:
                    if(dato.matches("[0-9]")){
                        operandos[0] = operandos[0].concat(dato);
                        mostrarTexto();
                        
                    }else{
                        if(dato.equalsIgnoreCase("+")||dato.equalsIgnoreCase("-")
                            ||dato.equalsIgnoreCase("/")||dato.equalsIgnoreCase("*")){
                        operandos[1] = dato;
                        mostrarTexto();
                        contador++;
                    }
                        
                    }
                    
                    break;
                case 1:
                    if(dato.equalsIgnoreCase("+")||dato.equalsIgnoreCase("-")
                            ||dato.equalsIgnoreCase("/")||dato.equalsIgnoreCase("*")){
                        operandos[1] = dato;
                        mostrarTexto();
                        contador++;
                    }else{
                        contador--;
                    }
                    
                    break;
                case 2:
                    if(dato.matches("[0-9]")){
                        operandos[2] = dato;
                        mostrarTexto();
                        
                    }else{
                        contador--;
                    }
                    break;
            }
            

        }

        
        

    }
    
    private void hacerCuenta(){
        
        double dato1=Integer.parseInt(operandos[0]);
        double dato2=Integer.parseInt(operandos[2]);
        switch (operandos[1]) {
            case "+":
                areaTexto.setText(String.valueOf(dato1+dato2));
                break;
            case "-":
                areaTexto.setText(String.valueOf(dato1-dato2));
                break;
            case "/":
                areaTexto.setText(String.valueOf(dato1/dato2));
                break;
            case "*":
                areaTexto.setText(String.valueOf(dato1*dato2));
                break;
                
        }
        
       
        
    }
     private void mostrarTexto(){
            String texto1,texto2,texto3;
            texto1=operandos[0];
            texto2=operandos[1];
            texto3=operandos[2];        
            if (texto1==null){
                texto1="";
            }
            if (texto2==null){
                texto2="";
            }
            if (texto3==null){
                texto3="";
            }
            
            areaTexto.setText(texto1 + texto2 + texto3);
            
        }
        
    
     private void presionarC(){
         operandos[0]=null;
                operandos[1]=null;
                operandos[2]=null;
                contador=0;
         
     }
}


