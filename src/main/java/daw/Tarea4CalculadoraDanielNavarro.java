/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw;

import javax.swing.JFrame;

/**
 *
 * @author daniel
 */
public class Tarea4CalculadoraDanielNavarro {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
    	frame.setBounds(250, 250, 0, 0);
    	frame.add(new PanelPrincipal());
   	 
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.pack();
   	 
	}

    }

