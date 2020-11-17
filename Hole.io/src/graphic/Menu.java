package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import settings.Settings;

public class Menu extends JPanel{

	private static final long serialVersionUID = 1L;
	private ArrayList<JLabel> buttons;
	private JLabel mainlabel;
	
	public Menu() {
		buttons=new ArrayList<JLabel>();
		ImageIcon label=new ImageIcon("assets"+File.separator+"imagesMenu"+File.separator+"main_label.jpg");	
		mainlabel=new JLabel(label);
		for(int i=0; i<4; i++)
		{		
			ImageIcon image = new ImageIcon("assets"+File.separator+"imagesMenu"+File.separator+i+".png");
			Image img = image.getImage().getScaledInstance(Settings.SCALED_WIDTH, Settings.SCALED_HEIGHT, Image.SCALE_SMOOTH);	
			ImageIcon scaled=new ImageIcon(img);
	    	JLabel button = new JLabel(scaled);
	        buttons.add(button);	      
			
		}
		this.setBackground(Color.BLACK);
		this.draw();
	}
	
	public void draw() {
		this.setLayout(new BorderLayout());
		this.add(mainlabel, BorderLayout.PAGE_START);
		this.drawCenter();
	}
	
	public void drawCenter() {
		JPanel center=new JPanel();
		center.setBackground(Color.BLACK);
	
		GridLayout grid=new GridLayout(5,1);
		grid.setVgap(10);	
		center.setLayout(grid);
		for(int i=0; i<4; i++)
		{
		
			buttons.get(i).addMouseListener(new ButtonListener(i,buttons.get(i)));
			center.add(buttons.get(i));
			
		}
        this.add(center,BorderLayout.CENTER);		
	}
}