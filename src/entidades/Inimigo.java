package entidades;

public abstract class Inimigo extends Personagem{

    public Inimigo(float x, float y) {
        super(x, y, DEFAULT_LARGURA, DEFAULT_ALTURA);
    }
    
    public abstract void mover(float moverX, float moverY);
}
