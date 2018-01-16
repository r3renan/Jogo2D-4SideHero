package game;

import estados.Estado;

public class EnemyManager {
    long ultimoSpawn;
    long agora;
    
    EnemyManager(){
        ultimoSpawn = System.nanoTime();
    }
    
    public void update(){
        agora = System.nanoTime();
        if ((agora - ultimoSpawn) > 1000000000){
            ultimoSpawn = System.nanoTime();
            spawnar();
        }
    }
    
    public void spawnar(){
        Estado.getEstado().spawnarInimigos();
    }
}
