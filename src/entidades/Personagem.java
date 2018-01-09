package entidades;

import java.awt.Graphics;

public abstract class Personagem extends Entidade{
    
    protected int vida;

    public Personagem(float x, float y) {
        super(x, y);
        vida = 10;
    }
}
