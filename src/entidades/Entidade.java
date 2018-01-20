package entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import estados.Estado;
import game.Game;

public abstract class Entidade {
    
    protected float x, y;
    protected int largura, altura;
    protected Rectangle hitbox;
    protected Estado gameState;
    protected Game game;
    
    public Entidade(float x, float y, int largura, int altura, Estado gameState){
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.gameState = gameState;
        this.hitbox = new Rectangle(0, 0, largura, altura);
        this.game = gameState.getGame();
    }
    
    public abstract void update();
    
    public abstract void render(Graphics g);
    
    public abstract void onDestroy();
    
    public boolean checkCollision(float xOffset, float yOffset, Entidade atacante){
        for (Entidade e : gameState.getEntidades()){
            if (e.equals(this))
                continue;
            if (e.getHitbox(0f, 0f).intersects(getHitbox(xOffset, yOffset))){ //e = Entidade atacada | atacante = entidade que chamou a função
                if (e.getClass().getSuperclass().getName().equals("entidades.inimigos.Inimigo") && atacante.getClass().getName().equals("entidades.Bala")){
                    e.onDestroy();
                    return true;
                }
                if (e.getClass().getSuperclass().getName().equals("entidades.inimigos.Inimigo") && atacante.getClass().getName().equals("entidades.Jogador")){
                    atacante.onDestroy();
                    return true;
                }
                if (e.getClass().getName().equals("entidades.Jogador") && atacante.getClass().getSuperclass().getName().equals("entidades.inimigos.Inimigo")){
                    e.onDestroy();
                    return true;
                }
                if (e.getClass().getSuperclass().getName().equals("entidades.powerups.PowerUp")){
                    if (atacante.getClass().getName().equals("entidades.Jogador")){ //Jogador interagindo com PowerUp
                        e.onDestroy();
                        return true;
                    } else { //Qualquer outra entidade interagindo com PowerUp (nada acontece)
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    //GETTERS / SETTERS
    public Rectangle getHitbox(float xOffset, float yOffset){
        return new Rectangle((int) (x + hitbox.x + xOffset), (int) (y + hitbox.y + yOffset), hitbox.width, hitbox.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
