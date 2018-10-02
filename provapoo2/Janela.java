/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provapoo2;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author DEVINOVA-VOSTRO
 */
public class Janela extends JFrame{
    
    private int rows = 10;
    private int cols = 10;
    private GridLayout gl = new GridLayout(rows, cols);
    private String jogador = "X";
    private int[] pontuacao;
    private Color cor = Color.red;
    private ArrayList<LabelTunado> lt;
    
    
    public Janela(){
        this.init();
    }
    private void init(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        pontuacao = new int[2];
        
        this.setTitle("Jogador: " + jogador);
        lt = new ArrayList<>();
        this.setLayout(gl);
        
        for(int r=0; r < rows; r++) {
            for(int c=0; c < cols; c++){
                if(c%2 == 0 && r%2 == 0){
                    BotaoTunado bt = new BotaoTunado(" ", c, r);
                    
                    bt.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            verifyGame(bt);
                        }
                    });
                    this.add(bt);
                }
                else if(c%2 == 1 && r%2 == 1){
                    LabelTunado lb = new LabelTunado(" ", c, r);
                    lt.add(lb);
                    this.add(lb);
                }
                else if((c%2 == 1 && r%2 == 0) || (c%2 == 0 && r%2 == 1)){
                    PanelTunado pt = new PanelTunado();
                    this.add(pt);
                } 
            }
        }
        
        this.setSize(rows*50, cols*50);
        //rows-=1;
        //cols-=1;
    }
    private void verifyGame(BotaoTunado bt){
        if(!bt.isClicado()){
            
            bt.setClicado(true, jogador);
            
            
            if(jogador.equals("X")){
                jogador = "O";
                cor = Color.blue;                
            }
            else{
                jogador = "X";
                cor = Color.red; 
            }
            this.setTitle("Jogador: " + jogador);
            
            Component[] c = this.getContentPane().getComponents();
            
            try{
                //i=(x+1)*r(y) cima
                //i=()
                
                if(bt.getX() > 0){
                    ((PanelTunado)c[(bt.getX()-1)+(rows*bt.getY())]).setBackground(cor);
                }
                if(bt.getX() < cols-1){
                    ((PanelTunado)c[(bt.getX()+1)+rows*bt.getY()]).setBackground(cor);
                }
                if(bt.getY() < rows-1 ){
                    ((PanelTunado)c[bt.getX()+rows*(bt.getY()+1)]).setBackground(cor);
                }
                if(bt.getY() > 0){
                    ((PanelTunado)c[(bt.getX() + rows * (bt.getY()-1))]).setBackground(cor);
                }
                
                String ganhador = " ";
                for(LabelTunado lbtu : lt){
                    ganhador = lbtu.verificarPontos(c, rows);
                    if(!ganhador.equals(" ")){
                        if(ganhador.equals("X")) pontuacao[0]++;
                        else if(ganhador.equals("O")) pontuacao[1]++;
                        System.out.println("Vencedor até o momento: " + ganhador);
                        break;
                    }
                }
                String msgVencedor = this.getTitle();
                for(Component cmp : c){
                    if(cmp instanceof BotaoTunado){
                         if(!((BotaoTunado) cmp).isClicado()){
                             msgVencedor = this.getTitle();
                             break;
                         }
                         if(this.pontuacao[0] > this.pontuacao[1]) msgVencedor = "O grande vencedor é: X";
                         else if(this.pontuacao[1] > this.pontuacao[0]) msgVencedor = "O grande vencedor é: O";
                         
                    }
                }
                this.setTitle(msgVencedor);
            } catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
}
