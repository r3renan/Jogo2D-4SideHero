package game;

import estados.Estado;

public class EnemyManager {
    long ultimoSpawn;
    long agora;
    Game game;
    
    EnemyManager(Game game){
        this.game = game;
        ultimoSpawn = System.nanoTime();
    }
    
    public void update(){
        if ((game.agora - ultimoSpawn) > 1000000000){
            ultimoSpawn = System.nanoTime();
            if(Estado.getEstado().getClass().getName().equals("estados.EstadoJogo"))
                spawnar();
        }
    }
    
    public void spawnar(){
        Estado.getEstado().spawnarInimigos();
    }
}
