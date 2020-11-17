package settings;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Settings {

	public final static int WINDOW_WIDTH = 481;
	public final static int WINDOW_HEIGHT = 518;
	public final static int CELL_SIZE = 30;
	public final static int SQUARE = 28;
	public final static int SIZE = 32;
	public final static int SCALED_WIDTH = 250;
	public final static int SCALED_HEIGHT = 90;
	public final static int CELLS = 15;
	
	public final static String cellImg=("assets"+File.separator+"imagesEditor"+File.separator+"cell.png");
	public final static String holeImg=("assets"+File.separator+"images"+File.separator+"hole_right");
	public final static String fruitImg=("assets"+File.separator+"images"+File.separator+"fruit.png");
	public final static String flowerImg=("assets"+File.separator+"images"+File.separator+"flower.png");
	public final static String brickImg=("assets"+File.separator+"images"+File.separator+"Brick.png");
	
	public final static ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
		Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon.setImage(image);
        return icon;
	}
}