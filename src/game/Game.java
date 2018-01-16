package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import estados.EstadoJogo;
import estados.Estado;

public class Game implements Runnable{
    private Display display;
    public int width, height;
    public String title;
    private boolean running = false;
    
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    private Estado gameState;
    
    //Input
    private KeyManager keyManager;
    private EnemyManager enemyManager;
    
    //Outros
    private final String TEXTO_SCORE = "Score: ";
    private StringBuilder sb = new StringBuilder(64);
    
    private StringBuilder score;
    private char[] textoScore;
    
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
        
        gameState = new EstadoJogo(this);
        Estado.setState(gameState);
        
        sb.append(TEXTO_SCORE);
    }
    
    
    
    private void update(){
        keyManager.update();
        enemyManager.update();
        
        score = sb;
        score.delete(7, score.length());
        score.append(Estado.getEstado().getJogador().getScore());
        textoScore = score.toString().toCharArray();
        
        if(Estado.getEstado() != null){
            Estado.getEstado().update();
        }
    }
    
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics(); //Inicializar modulo gráfico
        g.clearRect(0, 0, width, height); //Limpar tela anterior
        //Elementos da tela
        
        if(Estado.getEstado() != null){
            Estado.getEstado().render(g);
        }
        
        g.drawChars(textoScore, 0, textoScore.length, 25, 25);
        
        //Fim dos elementos
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
    
    public Estado getGameState(){
        return Estado.getEstado();
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
