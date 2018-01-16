package estados;

import entidades.Entidade;
import entidades.Jogador;
import java.awt.Graphics;
import java.util.ArrayList;
import game.Game;

public abstract class Estado {
    
    private static Estado estadoAtual = null;
    protected Game game;
    
    public Estado(Game game){
        this.game = game;
    }
    
    public static void setState(Estado state){
        estadoAtual = state;
    }
    
    public static Estado getEstado(){
        return estadoAtual;
    }
    
    
    public abstract void update();
    
    public abstract void render(Graphics g);
    
    public abstract void inserirBala(Entidade e);
    
    public abstract void spawnarInimigos();
    
    public abstract Jogador getJogador();
    
    public abstract ArrayList<Entidade> getEntidades();
    
    public abstract void removerEntidade(Entidade e);
    
}
