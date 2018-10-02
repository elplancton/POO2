/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provapoo2;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;

/**
 *
 * @author DEVINOVA-VOSTRO
 */
public class LabelTunado extends JLabel{
    private int x;
    private int y;
    
    public LabelTunado(String texto, int x, int y){
        super(texto);
        this.setSize(5, 5);
        this.x = x;
        this.y = y;
        this.setText(texto);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public String verificarPontos(Component[] c, int r){
        try {
                if(((PanelTunado)c[(this.getX()-1)+(r*this.getY())]).getBackground() == Color.red
                        && ((PanelTunado)c[(this.getX()+1)+r*this.getY()]).getBackground() == Color.red
                        && ((PanelTunado)c[this.getX()+r*(this.getY()+1)]).getBackground() == Color.red
                        && ((PanelTunado)c[this.getX()+r*(this.getY()-1)]).getBackground() == Color.red){
                    return "O";
                }
                else if(((PanelTunado)c[(this.getX()-1)+(r*this.getY())]).getBackground() == Color.blue
                        && ((PanelTunado)c[(this.getX()+1)+r*this.getY()]).getBackground() == Color.blue
                        && ((PanelTunado)c[this.getX()+r*(this.getY()+1)]).getBackground() == Color.blue
                        && ((PanelTunado)c[this.getX()+r*(this.getY()-1)]).getBackground() == Color.blue){
                    return "X";
                }
                
        } catch (Exception e) {
        }
        return " ";
    }
}
