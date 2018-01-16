package entidades.inimigos;
import entidades.Personagem;
import estados.Estado;
import java.awt.Rectangle;

public abstract class Inimigo extends Personagem{
    
    boolean isAlive;
    long horaMorte;
    long agora;

    public Inimigo(float x, float y, Estado gameState) {
        super(x, y, DEFAULT_LARGURA, DEFAULT_ALTURA, gameState);
        isAlive = true;
    }
    
    @Override
    public void onDestroy(){
        this.hitbox = new Rectangle(0, 0, 0, 0);
        this.horaMorte = System.nanoTime();
        this.agora = horaMorte;
        recompensarPontos();
        spawnarPowerUp();
        this.isAlive = false;
        //A função de remoção é chamado pelo metodo update, pois após a morte do
        //inimigo (isAlive = false) o render passa a exibir uma imagem diferente por 1
        //segundo, até em seguida eliminar o inimigo da lista de entidades
    }
    
    public abstract void spawnarPowerUp();
    
    public abstract void recompensarPontos();
}
