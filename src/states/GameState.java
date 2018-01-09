package states;

import entidades.Bala;
import entidades.Jogador;
import graphics.Assets;
import java.awt.Graphics;
import game.Game;
import java.util.ArrayList;

public class GameState extends State{
    
    private Jogador jogador;
    public static ArrayList<Bala> balas = new ArrayList<Bala>();
    
    public GameState(Game game){
        super(game);
        jogador = new Jogador(game, 100, 100);
    }
    
    @Override    
    public void update(){
        jogador.update();
        for (Bala bala : balas){
            bala.update();
        }
    }
    
    @Override
    public void render(Graphics g){
        jogador.render(g);
        for (Bala bala : balas){
            bala.render(g);
        }
    }

    public void inserirBala(Bala bala) {
        this.balas.add(bala);
    }
}
