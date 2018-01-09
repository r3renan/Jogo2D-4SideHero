package entidades;

import graphics.Assets;
import java.awt.Graphics;

public class Bala extends Entidade{
    
    String direcaoDaBala;
    float velocidade;
    
    public Bala(float x, float y, String direcao, float velocidade) {
        super(x, y);
        this.velocidade = velocidade;
        direcaoDaBala = direcao;
    }

    @Override
    public void update() {
        if (direcaoDaBala == "up")
            y -= velocidade;
        if (direcaoDaBala == "down")
            y += velocidade;
        if (direcaoDaBala == "left")
            x -= velocidade;
        if (direcaoDaBala == "right")
            x += velocidade;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bala, (int) this.x, (int) this.y, null);
    }
    
}
