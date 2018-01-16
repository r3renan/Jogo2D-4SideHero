package entidades.powerups;
import graphics.Assets;
import java.awt.Graphics;
import estados.Estado;

public class BuffShotSpeed extends PowerUp{
    
    long agora, spawn;
    
    public BuffShotSpeed(float x, float y, Estado gameState) {
        super(x, y, gameState);
        spawn = System.nanoTime();
    }

    @Override
    public void update() {
        agora = System.nanoTime();
        if (agora - spawn > DURACAO_NO_MAPA) gameState.removerEntidade(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.buffShotSpeed, (int) x, (int) y, altura, largura, null);
    }

    @Override
    public void onDestroy() {
        gameState.getJogador().aumentarVelocidadeBala(2f);
        gameState.removerEntidade(this);
    }
}
