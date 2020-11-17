package graphic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import settings.*;

public class Graphic {
	private static Menu menu;
	private static Credits credits;
	private static Options options;
	private static JFrame f;
	private static Scene scene;
	public static Sound s;
	
	public static void crea() {
		s = new Sound();
		menu = new Menu();
		credits = new Credits();
		scene = new Scene();
		options = new Options();

		f = new JFrame();
		f.setSize(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);
		f.setUndecorated(true);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		Graphic.setPanel(menu);		
		f.setFocusable(true);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void setPanel(JPanel panel) {
		if(panel==menu)
			Sound.Menu();
		if(panel==scene) {
			Sound.MenuStop();
			Sound.menu.setFramePosition(0);
		}
		f.setContentPane(panel);
		f.revalidate();
		f.repaint();
	}
	
	public static void listener() {
		f.addKeyListener(scene.keyEvents);
	}
	
	public static void listenerMenu() {
		f.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE && Scene.runGame==false) {
					Graphic.setPanel(Graphic.getMenu());
				}
		        					
			}
		});
	}

	public static Menu getMenu() {return menu;}
	public static Scene getScene() {return scene;}
	public static Credits getCredits() {return credits;}
	public static Options getOptions() {return options;}
	
	public static void setScene(Scene scene) {Graphic.scene = scene;}
	public static void setMenu(Menu menu) {Graphic.menu = menu;}
	public static void setCredits(Credits credits) {Graphic.credits = credits;}
	public static void setOptions(Options options) {Graphic.options = options;}	
}