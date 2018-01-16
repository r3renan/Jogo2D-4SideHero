package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    
    private boolean[] keys;
    public boolean up, down, left, right, setaUp, setaDown, setaLeft, setaRight;
    
    public KeyManager(){
        keys = new boolean[256];
    }
    
    public void update(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        
        setaUp = keys[KeyEvent.VK_UP];
        setaDown = keys[KeyEvent.VK_DOWN];
        setaLeft = keys[KeyEvent.VK_LEFT];
        setaRight = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
