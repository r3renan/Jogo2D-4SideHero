package states;

import entidades.Bala;
import entidades.Entidade;
import entidades.InimigoVermelho;
import entidades.Jogador;
import java.awt.Graphics;
import tilegame.Game;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;

public class GameState extends State{
    
    private Jogador jogador;
    public ArrayList<Entidade> entidades;
    
    public GameState(Game game){
        super(game);
        entidades = new ArrayList<>();
        jogador = new Jogador(game, 100, 100);
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
    public void inserirBala(Bala bala) {
        this.entidades.add(bala);
    }
    
    @Override
    public void spawnarInimigos(){
        int spawn = (new Random()).nextInt(4);
        switch(spawn){
            case 0:
                entidades.add(new InimigoVermelho(50, 250));
                break;
            case 1:
                entidades.add(new InimigoVermelho(250, 50));
                break;
            case 2:
                entidades.add(new InimigoVermelho(400, 50));
                break;
            case 3:
                entidades.add(new InimigoVermelho(50, 600));
                break;
        }
    }

    @Override
    public Jogador getJogador() {
        return jogador;
    }
}
