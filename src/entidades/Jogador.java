package entidades;

import graphics.Assets;
import java.awt.Graphics;
import tilegame.Game;

public class Jogador extends Personagem{
    
    private Game game;
    
    String direcao = "up";
    
    long ultimoTiro, agora;
    long recargaTiro = 500000000;
    
    float velocidadeBala;
    int dano;
    
    public Jogador(Game game, float x, float y) {
        super(x, y, DEFAULT_LARGURA, DEFAULT_ALTURA);
        this.game = game;
        velocidadeBala = 5;
        dano = 5;
    }

    public void atirar(){
        if (agora - ultimoTiro > recargaTiro){
            switch(direcao){
                case "up":
                    game.getGameState().inserirBala(new Bala(x+10, y-10, direcao, velocidadeBala, dano));
                    break;
                case "down":
                    game.getGameState().inserirBala(new Bala(x+10, y+30, direcao, velocidadeBala, dano));
                    break;
                case "left":
                    game.getGameState().inserirBala(new Bala(x-10, y+10, direcao, velocidadeBala, dano));
                    break;
                case "right":
                    game.getGameState().inserirBala(new Bala(x+30, y+10, direcao, velocidadeBala, dano));
                    break;
            }
            ultimoTiro = System.nanoTime();
        }
    }
    
    @Override
    public void update() {
        agora = System.nanoTime();
        
        if(game.getKeyManager().up){
            direcao = "up";
            if (y > 15) y -= velocidadeMovimento;
        }
        if(game.getKeyManager().down){
            direcao = "down";
            if (y < 610) y += velocidadeMovimento;
        }
        if(game.getKeyManager().left){
            direcao = "left";
            if (x > 10) x -= velocidadeMovimento;
        }
        if(game.getKeyManager().right){
            direcao = "right";
            if (x < 610) x += velocidadeMovimento;
        }
        
        if(game.getKeyManager().setaDown){
            direcao = "down";
            atirar();
        }
        if(game.getKeyManager().setaUp){
            direcao = "up";
            atirar();
        }
        if (game.getKeyManager().setaLeft){
            direcao = "left";
            atirar();
        }
        if (game.getKeyManager().setaRight){
            direcao = "right";
            atirar();
        }
        
        if(game.getKeyManager().uparVelocidadeBala)
            velocidadeBala++;
        if(game.getKeyManager().uparVelocidadeMovimento)
            velocidadeMovimento++;
    }

    @Override
    public void render(Graphics g) {
        switch(direcao){
            case "up":
                g.drawImage(Assets.playerCima, (int) x, (int) y, largura, altura, null);
                break;
            case "down":
                g.drawImage(Assets.playerBaixo, (int) x, (int) y, largura, altura, null);
                break;
            case "left":
                g.drawImage(Assets.playerEsquerda, (int) x, (int) y, largura, altura, null);
                break;
            case "right":
                g.drawImage(Assets.playerDireita, (int) x, (int) y, largura, altura, null);
                break;
        }
    }
}