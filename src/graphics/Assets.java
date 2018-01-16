package graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static SpriteSheet player = new SpriteSheet(ImageLoader.loadImage("/Player.png"));
    
    public static BufferedImage playerCima = player.crop(0, 0, 30, 30);
    public static BufferedImage playerDireita = player.crop(30, 0, 30, 30);
    public static BufferedImage playerBaixo = player.crop(60, 0, 30, 30);
    public static BufferedImage playerEsquerda = player.crop(90, 0, 30, 30);
    
    public static BufferedImage bala = ImageLoader.loadImage("/Bala.png");
    
    public static BufferedImage inimigoVermelho = ImageLoader.loadImage("/Enemy.png");
    public static BufferedImage inimigoMorto50 = ImageLoader.loadImage("/EnemyDeath.png");
    
    public static BufferedImage buffShotSpeed = ImageLoader.loadImage("/buffShotSpeed.png");
    public static BufferedImage buffReload = ImageLoader.loadImage("/buffReload.png");
    public static BufferedImage buffDoubleAttack = ImageLoader.loadImage("/buffDoubleAttack.png");
}
