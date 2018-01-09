package game;

import display.Display;
import graphics.Assets;
import graphics.ImageLoader;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import states.GameState;
import states.MenuState;
import states.State;

public class Game implements Runnable {

    private Display display;
    private boolean executando = false; //Omitido do diagrama de classes por não ser relevante para a apresentação

    private Thread thread;

    private BufferStrategy bs; //Omitido do diagrama de classes por não ser relevante para a apresentação
    private Graphics gerenciadorGrafico;

    //States
    private State gameState;
    private State menuState; //Não utilizado no momento

    //Input
    private KeyManager keyManager;

    public Game(String titulo, int largura, int altura) {
        display = new Display(titulo, largura, altura);

        keyManager = new KeyManager();
    }

    private void inicializar() {
        display.getFrame().addKeyListener(keyManager);

        gameState = new GameState(this);
        //menuState = new MenuState(this);
        State.setState(gameState);

    }

    private void update() {
        keyManager.update();

        if (State.getState() != null) {
            State.getState().update();
        }
    }

    private void render() {
        //Funções irrelevantes para a apresentação
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        gerenciadorGrafico = bs.getDrawGraphics();
        //Fim das funções irrelevantes para a apresentação
        
        //LIMPA A TELA DESENHANDO UM QUADRADO VAZIO DO TAMANHO DO DISPLAY
        gerenciadorGrafico.clearRect(0, 0, display.getLargura(), display.getAltura());

        //CHAMA A FUNÇÃO render() DO GAMESTATE, RENDERIZANDO TODOS OS OBJETOS QUE ELE POSSUI
        if (State.getState() != null) {
            State.getState().render(gerenciadorGrafico);
        }

        //EXIBE NA TELA OS OBJETOS RENDERIZADOS
        bs.show();
        gerenciadorGrafico.dispose();
    }

    public void run() {
        inicializar();

        //Variaveis referentes a atualização de frames na tela (FPS), irrelevante para a apresentação
        int fps = 60;
        double tempoEntreFrames = 1000000000 / fps; //1 segundo dividido por 60
        double delta = 0;
        long agora;
        long lastTime = System.nanoTime();
        //Fim das variaveis referentes a atualização de frames na tela (FPS), irrelevante para a apresentação

        while (executando) {
            agora = System.nanoTime();
            delta += (agora - lastTime) / tempoEntreFrames;
            lastTime = agora;

            if (delta >= 1) {
                update();
                render();
                delta--;
            }
        }

        stop();
    }

    public synchronized void start() {
        if (executando == true) { //Verificação para garantir que não haverão duas instancias do jogo rodando simultaneamente
            return;
        }
        executando = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (executando == false) {
            return;
        }
        executando = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //GETTERS E SETTERS
    public KeyManager getKeyManager() {
        return keyManager;
    }

    public State getGameState() {
        return State.getState();
    }
}
