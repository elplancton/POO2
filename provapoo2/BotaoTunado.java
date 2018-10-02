/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provapoo2;

import javax.swing.JButton;

/**
 *
 * @author DEVINOVA-VOSTRO
 */
public class BotaoTunado extends JButton{
    private int x;
    private int y;
    private boolean clicado = false;
    
    public BotaoTunado(String texto, int x, int y){
        super(texto);
        this.setSize(1, 1);
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

    public boolean isClicado() {
        return clicado;
    }

    public void setClicado(boolean clicado, String jogador) {
        this.setText(jogador);
        this.clicado = clicado;
    }
    
    
    
}
