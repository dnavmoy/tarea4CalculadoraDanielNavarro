/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    private static double resultado;

    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
        contador = 0;

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

        areaTexto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               
                char tecla=e.getKeyChar();
                System.out.println(tecla);
                
                
                    
            switch (tecla){
                case '1':
                botonera.getBoton(1).doClick();
                break;
                case '2':
                botonera.getBoton(2).doClick();
                break;
                case '3':
                botonera.getBoton(3).doClick();
                break;
                case '4':
                botonera.getBoton(4).doClick();
                break;
                case '5':
                botonera.getBoton(5).doClick();
                break;
                case '6':
                botonera.getBoton(6).doClick();
                break;
                case '7':
                botonera.getBoton(7).doClick();
                break;
                case '8':
                botonera.getBoton(8).doClick();
                break;
                case '9':
                botonera.getBoton(9).doClick();
                break;
                case '0':
                botonera.getBoton(0).doClick();
                break;
                case '=':
                botonera.getBoton(14).doClick();
                break;
                case '-':
                botonera.getBoton(11).doClick();
                break;
                case '+':
                botonera.getBoton(10).doClick();
                break;
                case '*':
                botonera.getBoton(12).doClick();
                break;
                case '/':
                botonera.getBoton(13).doClick();
                break;
            }
//              
            }

            @Override
            public void keyPressed(KeyEvent e) {
                 if(e.getExtendedKeyCode()==KeyEvent.VK_ENTER) {
                botonera.getBoton(14).doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
//      

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

            if (dato.equalsIgnoreCase("=") && operandos[0] != null && operandos[1] != null && operandos[2] != null) {

                hacerCuenta();
                presionarC();
                operandos[0] = areaTexto.getText();
            }
            if (dato.equalsIgnoreCase("c")) {
                presionarC();
                mostrarTexto();
            }

            switch (contador) {
                case 0:
                    if (dato.matches("[0-9]")) {
                        if (operandos[0] != null && resultado != Double.parseDouble(operandos[0])) {
                            operandos[0] = operandos[0] + dato;
                            mostrarTexto();
                        } else {
                            operandos[0] = dato;
                            mostrarTexto();
                        }
                    } else {
                        if (dato.equalsIgnoreCase("+") || dato.equalsIgnoreCase("-")
                                || dato.equalsIgnoreCase("/") || dato.equalsIgnoreCase("*")) {
                            operandos[1] = dato;
                            mostrarTexto();
                            contador = 2;
                        }

                    }

                    break;
                case 1:
                    if (dato.equalsIgnoreCase("+") || dato.equalsIgnoreCase("-")
                            || dato.equalsIgnoreCase("/") || dato.equalsIgnoreCase("*")) {
                        operandos[1] = dato;
                        mostrarTexto();
                        contador++;
                    } else {
                        contador--;
                    }

                    break;
                case 2:
                    if (dato.matches("[0-9]")) {
                        if (operandos[2] != null) {
                            operandos[2] = operandos[2] + dato;
                            mostrarTexto();
                        } else {
                            operandos[2] = dato;
                            mostrarTexto();
                        }
                    } else {
                        hacerCuenta();
                        operandos[0] = areaTexto.getText();
                        operandos[1] = dato;
                        operandos[2] = null;
                        mostrarTexto();
                        contador = 2;
                    }
                    break;
            }

        }

    }

    private double hacerCuenta() {

        double dato1 = Double.parseDouble(operandos[0]);

        double dato2 = Double.parseDouble(operandos[2]);
        switch (operandos[1]) {
            case "+":
                areaTexto.setText(String.valueOf(dato1 + dato2));
                break;
            case "-":
                areaTexto.setText(String.valueOf(dato1 - dato2));
                break;
            case "/":
                areaTexto.setText(String.valueOf(dato1 / dato2));
                break;
            case "*":
                areaTexto.setText(String.valueOf(dato1 * dato2));
                break;

        }
        contador = 0;
        operandos[0] = areaTexto.getText();
        return resultado = Double.parseDouble(areaTexto.getText());
    }

    private void mostrarTexto() {
        String texto1, texto2, texto3;
        texto1 = operandos[0];
        texto2 = operandos[1];
        texto3 = operandos[2];
        if (texto1 == null) {
            texto1 = "";
        }
        if (texto2 == null) {
            texto2 = "";
        }
        if (texto3 == null) {
            texto3 = "";
        }

        areaTexto.setText(texto1 + texto2 + texto3);

    }

    private void presionarC() {
        operandos[0] = null;
        operandos[1] = null;
        operandos[2] = null;
        contador = 0;

    }

}
