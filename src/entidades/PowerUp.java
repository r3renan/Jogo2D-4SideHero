package entidades;

import java.awt.Graphics;

public abstract class PowerUp extends Entidade{

    public PowerUp(float x, float y) {
        super(x, y);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
