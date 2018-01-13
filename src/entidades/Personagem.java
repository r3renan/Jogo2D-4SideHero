package entidades;

public abstract class Personagem extends Entidade{
    
    protected int vida;
    protected float velocidadeMovimento;
    
    public static boolean isAlive = true;
    
    public static final int DEFAULT_LARGURA = 32,
                            DEFAULT_ALTURA = 32,
                            DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;

    public Personagem(float x, float y, int largura, int altura) {
        super(x, y, largura, altura);
        vida = DEFAULT_HEALTH;
        velocidadeMovimento = DEFAULT_SPEED;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public float getVelocidadeMovimento() {
        return velocidadeMovimento;
    }

    public void setVelocidadeMovimento(float velocidadeMovimento) {
        this.velocidadeMovimento = velocidadeMovimento;
    }

    public static boolean getIsAlive() {
        return isAlive;
    }
}
