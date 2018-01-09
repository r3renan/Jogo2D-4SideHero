package display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
    private JFrame frame;
    private Canvas canvas;
    
    private String titulo;
    private int largura, altura;
     
    public Display(String titulo, int largura, int altura){
        this.titulo = titulo;
        this.largura = largura;
        this.altura = altura;
        
        createDisplay();
    }
    
    private void createDisplay(){
        frame = new JFrame(titulo);
        frame.setSize(largura, altura);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(largura, altura));
        canvas.setMaximumSize(new Dimension(largura, altura));
        canvas.setMinimumSize(new Dimension(largura, altura));
        canvas.setFocusable(false);
        
        frame.add(canvas);
        frame.pack();
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
    
    public JFrame getFrame(){
        return frame;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
    
    public String getTitulo(){
        return titulo;
    }
}
