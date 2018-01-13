package tilegame;

import states.State;

public class EnemyManager {
    long ultimoSpawn;
    long agora;
    
    EnemyManager(){
        ultimoSpawn = System.nanoTime();
    }
    
    public void update(){
        agora = System.nanoTime();
        if ((agora - ultimoSpawn) > 2000000000){
            ultimoSpawn = System.nanoTime();
            spawnar();
        }
    }
    
    public void spawnar(){
        State.getState().spawnarInimigos();
    }
}
