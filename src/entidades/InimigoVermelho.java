package entidades;

import graphics.Assets;
import java.awt.Graphics;
import states.State;

public class InimigoVermelho extends Inimigo {
    public float distanciaX, distanciaY;
    
    public InimigoVermelho(float x, float y) {
        super(x, y);
        this.setVelocidadeMovimento(1.5f);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.inimigoVermelho,(int) x, (int) y, null);
    }

    @Override
    public void update() {
        calcularDistanciaManhatan();
    }
    
    @Override
    public void mover(float moverX, float moverY){
        this.x += moverX;
        this.y += moverY;
    }
    
    public void calcularDistanciaManhatan(){
        distanciaX = this.getX() - State.getState().getJogador().getX();
        distanciaY = this.getY() - State.getState().getJogador().getY();
        if (Math.abs(distanciaX) > Math.abs(distanciaY)){
            if (distanciaX > 0){
                mover(-velocidadeMovimento, 0);
            } else {
                mover(velocidadeMovimento, 0);
            }
        } else {
            if (distanciaY > 0){
                mover(0, -velocidadeMovimento);
            } else {
                mover(0, velocidadeMovimento);
            }
        }
    }
}
