package entidades;

import graphics.Assets;
import java.awt.Graphics;
import estados.Estado;
import game.Game;

public class Jogador extends Personagem{
    
    private Game game;
    
    int score;
    
    String direcao = "up";
    
    long ultimoTiro, agora;
    long recargaTiro = 500000000;
    String tipoTiro = "Default"; //Inserir outros tipos de tiro futuramente
    
    float velocidadeBala;
    
    public Jogador(Game game, Estado gameState, float x, float y) {
        super(x, y, DEFAULT_LARGURA, DEFAULT_ALTURA, gameState);
        this.game = game;
        velocidadeBala = 5;
        score = 0;
    }

    public void atirar(){
        if (agora - ultimoTiro > recargaTiro){
            if (tipoTiro.equals("Default")){
                switch(direcao){
                    case "up":
                        gameState.inserirBala(new Bala(x+10, y-10, direcao, velocidadeBala, gameState));
                        break;
                    case "down":
                        gameState.inserirBala(new Bala(x+10, y+30, direcao, velocidadeBala, gameState));
                        break;
                    case "left":
                        gameState.inserirBala(new Bala(x-10, y+10, direcao, velocidadeBala, gameState));
                        break;
                    case "right":
                        gameState.inserirBala(new Bala(x+30, y+10, direcao, velocidadeBala, gameState));
                        break;
                }
            }
            ultimoTiro = System.nanoTime();
        }
    }
    
    @Override
    public void update() {
        agora = System.nanoTime();
        
        if(game.getKeyManager().up){
            direcao = "up";
            if (y > 15) mover(0, -velocidadeMovimento);
        }
        if(game.getKeyManager().down){
            direcao = "down";
            if (y < 610) mover(0, velocidadeMovimento);
        }
        if(game.getKeyManager().left){
            direcao = "left";
            if (x > 10) mover(-velocidadeMovimento, 0);
        }
        if(game.getKeyManager().right){
            direcao = "right";
            if (x < 610) mover(velocidadeMovimento, 0);
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
    
    @Override
    public void onDestroy(){
        //Estado.setState(EstadoGameOver);
        gameState.removerEntidade(this);
    }
    
    public void aumentarVelocidadeBala(float v){
        this.velocidadeBala += v;
    }
    
    public void diminuirVelocidadeReload(long t){
        if (recargaTiro > 50000000) this.recargaTiro -= t;
    }
    
    public void aumentarScore(int x){
        score += x;
    }
    
    public String getScore(){
        return String.valueOf(score);
    }
}