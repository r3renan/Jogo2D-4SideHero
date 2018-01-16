package entidades.powerups;

import entidades.Entidade;
import estados.Estado;

public abstract class PowerUp extends Entidade{
    protected final long DURACAO_NO_MAPA = 4000000000L;

    public PowerUp(float x, float y, Estado gameState) {
        super(x, y, 10, 10, gameState);
    }
}
