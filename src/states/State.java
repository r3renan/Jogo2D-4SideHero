package states;

import entidades.Bala;
import entidades.Jogador;
import java.awt.Graphics;
import tilegame.Game;

public abstract class State {
    
    private static State currentState = null;
    
    public static void setState(State state){
        currentState = state;
    }
    
    public static State getState(){
        return currentState;
    }
    
    protected Game game;
    
    public State(Game game){
        this.game = game;
    }
    
    
    public abstract void update();
    
    public abstract void render(Graphics g);
    
    public abstract void inserirBala(Bala bala);
    
    public abstract void spawnarInimigos();
    
    public abstract Jogador getJogador();
    
}
