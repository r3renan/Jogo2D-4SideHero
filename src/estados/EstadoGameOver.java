package estados;

import entidades.Entidade;
import entidades.Jogador;
import game.Game;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstadoGameOver extends Estado{

    String mensagem = "GAME OVER";
    
    public EstadoGameOver(Game game) {
        super(game);
        
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawChars(mensagem.toCharArray(), 0, mensagem.length(), 300, 300);
    }

    @Override
    public void spawnarInimigos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Jogador getJogador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Entidade> getEntidades() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerEntidade(Entidade e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Game getGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
