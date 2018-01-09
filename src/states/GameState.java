package states;

import entidades.Bala;
import entidades.Entidade;
import entidades.Jogador;
import java.awt.Graphics;
import game.Game;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class GameState extends State{
    
    private Jogador jogador;
    public static ArrayList<Entidade> entidades;
    
    public GameState(Game game){
        super(game);
        entidades = new ArrayList<>();
        jogador = new Jogador(game, 100, 100);
        entidades.add(jogador);
    }
    
    @Override    
    public void update(){
        try{
            for (Entidade entidade : entidades){
                entidade.update();
            }
        }catch (ConcurrentModificationException e) {
            
        }
    }
    
    @Override
    public void render(Graphics g){
        try{
            for (Entidade entidade : entidades){
                entidade.render(g);
            }
        } catch (ConcurrentModificationException e){
            
        }
    }

    public void inserirBala(Bala bala) {
        entidades.add(bala);
    }
}
