/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author daniel
 */
public class PanelBotones extends JPanel{
    
    JButton[] grupoBotones = new JButton[16];
    
    public PanelBotones(){
        initComponents();
    }
    
    
    private void initComponents(){
        
        for( int i=0;i<10;i++){
            grupoBotones[i]= new JButton(Integer.toString(i));
        }
        grupoBotones[10] = new JButton("+");        
        grupoBotones[11] = new JButton("-");
        grupoBotones[12] = new JButton("*");
        grupoBotones[13] = new JButton("/");
        grupoBotones[14] = new JButton("=");
        grupoBotones[15] = new JButton("C");
        
        this.setLayout(new GridLayout(4, 4));
        
        this.add(grupoBotones[7]);
        this.add(grupoBotones[8]);
        this.add(grupoBotones[9]);
        this.add(grupoBotones[13]);
        this.add(grupoBotones[4]);
        this.add(grupoBotones[5]);
        this.add(grupoBotones[6]);
        this.add(grupoBotones[12]);
        this.add(grupoBotones[1]);
        this.add(grupoBotones[2]);
        this.add(grupoBotones[3]);
        this.add(grupoBotones[11]);
        this.add(grupoBotones[14]);
        this.add(grupoBotones[0]);
        this.add(grupoBotones[15]);
        this.add(grupoBotones[10]);
//        
//        for (JButton boton: grupoBotones){
//            this.add(boton);
//        }
        
        
       

    }
    
     public JButton[] getgrupoBotones(){
    		return grupoBotones;
	}  
}
