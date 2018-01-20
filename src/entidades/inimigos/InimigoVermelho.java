package entidades.inimigos;

import entidades.powerups.BuffReload;
import entidades.powerups.BuffBulletSpeed;
import graphics.Assets;
import java.awt.Graphics;
import estados.Estado;
import java.util.Random;

public class InimigoVermelho extends Inimigo {
    public float distanciaX, distanciaY;
    
    public InimigoVermelho(float x, float y, Estado gameState) {
        super(x, y, gameState);
        this.setVelocidadeMovimento(1.5f);
    }

    @Override
    public void render(Graphics g) {
        if (this.isAlive == true)
            g.drawImage(Assets.inimigoVermelho,(int) x, (int) y, null);
        else 
            g.drawImage(Assets.inimigoMorto50,(int) x, (int) y, null);
    }

    @Override
    public void update() {
        if(isAlive == true)
            calcularDistancia();
        else {
            if (game.agora - horaMorte > 300000000)
                gameState.removerEntidade(this);
        }
    }
    
    public void calcularDistancia(){
        distanciaX = this.getX() - gameState.getJogador().getX();
        distanciaY = this.getY() - gameState.getJogador().getY();
        
        if (Math.abs(distanciaX) > Math.abs(distanciaY)){ //Escolhe a maior distancia entre o inimigo e o jogador
            if (distanciaX > 0){ //Caso o inimigo esteja a direita do jogador
                mover(-velocidadeMovimento, 0);
            } else {
                mover(velocidadeMovimento, 0);
            }
        } else {
            if (distanciaY > 0){ //Caso o inimigo esteja abaixo do jogador
                mover(0, -velocidadeMovimento);
            } else {
                mover(0, velocidadeMovimento);
            }
        }
    }
    
    @Override
    public void recompensarPontos(){
        gameState.getJogador().aumentarScore(50);
    }

    @Override
    public void spawnarPowerUp() {
        switch(new Random().nextInt(5)){
            case 1:
                gameState.getEntidades().add(new BuffBulletSpeed((this.x + largura / 2), (this.y + altura / 2), gameState));
                break;
            case 2:
                gameState.getEntidades().add(new BuffReload((this.x + largura / 2), (this.y + altura / 2), gameState));
                break;
            case 3:
                //TODO
                break;
            default:
                break;
        }
    }
}
