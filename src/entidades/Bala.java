package entidades;

import graphics.Assets;
import java.awt.Graphics;
import estados.Estado;

public class Bala extends Entidade{
    
    String direcaoDaBala;
    float velocidade;
    
    public Bala(float x, float y, String direcao, float velocidade, Estado gameState) {
        super(x, y, 5, 5, gameState);
        this.velocidade = velocidade;
        direcaoDaBala = direcao;
    }

    @Override
    public void update() {
        switch(direcaoDaBala){
            case "up":
                if(!checkCollision(0f, -velocidade, this))
                    y -= velocidade;
                else
                    onDestroy();
                break;
            case "down":
                if(!checkCollision(0f, velocidade, this))
                    y += velocidade;
                else
                    onDestroy();
                break;
            case "left":
                if(!checkCollision(-velocidade, 0f, this))
                    x -= velocidade;
                else
                    onDestroy();
                break;
            case "right":
                if(!checkCollision(velocidade, 0f, this))
                    x += velocidade;
                else
                    onDestroy();
                break;
        }
        
        if (x < 0 || x > 650 || y < 0 || y > 650){ //Remover do jogo balas que estão fora da tela
            onDestroy();
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bala, (int) this.x, (int) this.y, null);
    }
    
    @Override
    public void onDestroy(){
        gameState.removerEntidade(this);
    };
}
