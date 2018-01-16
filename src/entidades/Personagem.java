package entidades;

import estados.Estado;

public abstract class Personagem extends Entidade{
    
    protected float velocidadeMovimento;
    
    public static final int DEFAULT_LARGURA = 32,
                            DEFAULT_ALTURA = 32;
    public static final float DEFAULT_SPEED = 3.0f;

    public Personagem(float x, float y, int largura, int altura, Estado gameState) {
        super(x, y, largura, altura, gameState);
        velocidadeMovimento = DEFAULT_SPEED;
    }
    
    public void mover(float moverX, float moverY){
        if (!checkCollision(moverX, 0f, this))
            this.x += moverX;
        if (!checkCollision(0f, moverY, this))
            this.y += moverY;
    }

    public float getVelocidadeMovimento() {
        return velocidadeMovimento;
    }

    public void setVelocidadeMovimento(float velocidadeMovimento) {
        this.velocidadeMovimento = velocidadeMovimento;
    }
}
