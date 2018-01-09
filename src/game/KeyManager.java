package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    
    private boolean[] teclas;
    public boolean cima, baixo, esquerda, direita, atirar;
    public boolean uparVelocidadeMovimento, uparVelocidadeBala;
    
    public KeyManager(){
        teclas = new boolean[256];
    }
    
    public void update(){
        cima = teclas[KeyEvent.VK_W];
        baixo = teclas[KeyEvent.VK_S];
        esquerda = teclas[KeyEvent.VK_A];
        direita = teclas[KeyEvent.VK_D];
        atirar = teclas[KeyEvent.VK_SPACE];
        uparVelocidadeMovimento = teclas[KeyEvent.VK_M];
        uparVelocidadeBala = teclas[KeyEvent.VK_N];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
    }
    
}
