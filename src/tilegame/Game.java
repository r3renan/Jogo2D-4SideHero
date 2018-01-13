package tilegame;

import display.Display;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import states.GameState;
import states.MenuState;
import states.State;

public class Game implements Runnable{
    private Display display;
    public int width, height;
    public String title;
    private boolean running = false;
    
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    private State gameState;
    private State menuState;
    
    //Input
    private KeyManager keyManager;
    private EnemyManager enemyManager;
    
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        
        keyManager = new KeyManager();
        enemyManager = new EnemyManager();
    }
    
    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        
        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);
        
    }
    
    private void update(){
        keyManager.update();
        enemyManager.update();
        
        if(State.getState() != null){
            State.getState().update();
        }
    }
    
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        //Draw here!
        
        if(State.getState() != null){
            State.getState().render(g);
        }
        
        //End drawing!
        bs.show();
        g.dispose();
    }
    
    @Override
    public void run(){
        init();
        
        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            
            if(delta >= 1){
                update();
                render();
                delta--;
            }
        }
        
        stop();
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
    }
    
    public State getGameState(){
        return State.getState();
    }
    
    public synchronized void start(){
        if(running == true)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if(running == false)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
