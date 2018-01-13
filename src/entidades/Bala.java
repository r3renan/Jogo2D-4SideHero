package entidades;

import graphics.Assets;
import java.awt.Graphics;

public class Bala extends Entidade{
    
    String direcaoDaBala;
    float velocidade;
    int dano;
    
    public Bala(float x, float y, String direcao, float velocidade, int dano) {
        super(x, y, 5, 5);
        this.velocidade = velocidade;
        this.dano = dano;
        direcaoDaBala = direcao;
    }

    @Override
    public void update() {
        switch(direcaoDaBala){
            case "up":
                y -= velocidade;
                break;
            case "down":
                y += velocidade;
                break;
            case "left":
                x -= velocidade;
                break;
            case "right":
                x += velocidade;
                break;
        }
        
        if (x < 0 || x > 650 || y < 0 || y > 650){
            //System.out.println("DESTROY");
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bala, (int) this.x, (int) this.y, null);
    }
    
}
