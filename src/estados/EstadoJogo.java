package estados;

import entidades.Entidade;
import entidades.inimigos.InimigoVermelho;
import entidades.Jogador;
import java.awt.Graphics;
import game.Game;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;

public class EstadoJogo extends Estado{
    
    private Jogador jogador;
    public ArrayList<Entidade> entidades;
    
    public EstadoJogo(Game game){
        super(game);
        entidades = new ArrayList<>();
        jogador = new Jogador(game, this, 325, 325);
        entidades.add(jogador);
    }
    
    @Override    
    public void update(){
        try{
            for (Entidade entidades : entidades){
                entidades.update();
            }
        } catch (ConcurrentModificationException e){
            
        }
    }
    
    @Override
    public void render(Graphics g){
        try{
            for (Entidade entidades : entidades){
                entidades.render(g);
            }
        } catch (ConcurrentModificationException e){
            
        }
    }

    @Override
    public void inserirBala(Entidade bala) {
        this.entidades.add(bala);
    }
    
    @Override
    public void removerEntidade(Entidade e){
        entidades.remove(e);
    }
    
    @Override
    public void spawnarInimigos(){
        int x = (new Random()).nextInt(5);
        switch (x){
            case 1:
                entidades.add(new InimigoVermelho((new Random()).nextInt(620), 0, this));
                break;
            case 2:
                entidades.add(new InimigoVermelho(0, (new Random()).nextInt(620), this));
                break;
            case 3:
                entidades.add(new InimigoVermelho(620, (new Random()).nextInt(620), this));
                break;
            case 4:
                entidades.add(new InimigoVermelho((new Random()).nextInt(620), 620, this));
                break;
        }
    }

    @Override
    public Jogador getJogador() {
        return jogador;
    }
    
    @Override
    public ArrayList<Entidade> getEntidades(){
        return entidades;
    }
}
