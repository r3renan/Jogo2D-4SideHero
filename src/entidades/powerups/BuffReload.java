package entidades.powerups;

import graphics.Assets;
import java.awt.Graphics;
import estados.Estado;

public class BuffReload extends PowerUp{
    long agora, spawn;
    
    public BuffReload(float x, float y, Estado gameState) {
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
        g.drawImage(Assets.buffReload, (int) x, (int) y, altura, largura, null);
    }

    @Override
    public void onDestroy() {
        gameState.getJogador().diminuirVelocidadeReload(50000000);
        gameState.removerEntidade(this);
    }
}
