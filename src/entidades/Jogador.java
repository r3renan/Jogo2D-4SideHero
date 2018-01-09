package entidades;

import graphics.Assets;
import java.awt.Graphics;
import java.util.Arrays;
import game.Game;

public class Jogador extends Personagem{
    
    private Game game;
    String direcao = "up";
    long ultimoTiro = 0;
    float velocidadeBala = 5;
    float velocidadeMovimento = 3;
    
    public Jogador(Game game, float x, float y) {
        super(x, y);
        this.game = game;
    }

    public void atirar(){
        if (direcao == "up")
            game.getGameState().inserirBala(new Bala(x+10, y-10, direcao, velocidadeBala));
        if (direcao == "down")
            game.getGameState().inserirBala(new Bala(x+10, y+30, direcao, velocidadeBala));
        if (direcao == "left")
            game.getGameState().inserirBala(new Bala(x-10, y+10, direcao, velocidadeBala));
        if (direcao == "right")
            game.getGameState().inserirBala(new Bala(x+30, y+10, direcao, velocidadeBala));
        ultimoTiro = System.nanoTime();
    }
    
    @Override
    public void update() {
        long agora = System.nanoTime();
        if(game.getKeyManager().cima){
            direcao = "up";
            y -= velocidadeMovimento;
        }
        if(game.getKeyManager().baixo){
            direcao = "down";
            y += velocidadeMovimento;
        }
        if(game.getKeyManager().esquerda){
            direcao = "left";
            x -= velocidadeMovimento;
        }
        if(game.getKeyManager().direita){
            direcao = "right";
            x += velocidadeMovimento;
        }
        if(game.getKeyManager().atirar)
            if (agora - ultimoTiro >= 500000000)
                atirar();
        
        if(game.getKeyManager().uparVelocidadeBala)
            velocidadeBala++;
        if(game.getKeyManager().uparVelocidadeMovimento)
            velocidadeMovimento++;
    }

    @Override
    public void render(Graphics g) {
        if(direcao == "up"){
            g.drawImage(Assets.playerCima, (int) x, (int) y, null);
        }
        if(direcao == "down"){
            g.drawImage(Assets.playerBaixo, (int) x, (int) y, null);
        }
        if(direcao == "left"){
            g.drawImage(Assets.playerEsquerda, (int) x, (int) y, null);
        }
        if(direcao == "right"){
            g.drawImage(Assets.playerDireita, (int) x, (int) y, null);
        }
    }
}
