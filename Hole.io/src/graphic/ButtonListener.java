package graphic;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import settings.Settings;

public class ButtonListener implements MouseListener {

	private int type;
	private JLabel label;
	private ImageIcon grayIcon;
	private ImageIcon icon;
	
	private void setIcon() {
		ImageIcon image=new ImageIcon("assets"+File.separator+"imagesMenu"+File.separator+type+".png");
		Image img = image.getImage().getScaledInstance(Settings.SCALED_WIDTH, Settings.SCALED_HEIGHT, Image.SCALE_SMOOTH);	
		this.icon = new ImageIcon(img);
	}
	
	private void setGrayIcon() {
		ImageIcon image=new ImageIcon("assets"+File.separator+"imagesMenu"+File.separator+"imagesMotion"+File.separator+type+".png");
		Image img = image.getImage().getScaledInstance(Settings.SCALED_WIDTH, Settings.SCALED_HEIGHT, Image.SCALE_SMOOTH);	
		this.grayIcon = new ImageIcon(img);
	}
	
	public ButtonListener(int type, JLabel label){
		this.type=type;
		this.label=label;
		setGrayIcon();
		setIcon();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		switch(type)
		{
		case 0:
			Scene.stopGame=false;
			Graphic.setPanel(Graphic.getScene());
			Graphic.getScene().game("level1.txt");
			Graphic.listener();
			break;
		case 1:
			this.label.setIcon(icon);
			Graphic.setPanel(Graphic.getOptions());
			Graphic.listenerMenu();
			break;
		case 2:
			this.label.setIcon(icon);
			Graphic.setPanel(Graphic.getCredits());
			Graphic.listenerMenu();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			break;
		}		
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.label.setIcon(grayIcon);		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.label.setIcon(icon);		
	}
}

