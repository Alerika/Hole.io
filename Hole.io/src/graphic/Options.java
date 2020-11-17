package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Options extends JPanel{
	private ArrayList<JLabel> optionsLabels;
	private ImageIcon yes;
	private ImageIcon nope;
	private boolean clicked=false;
	
	public void addListener() {
		for(int i=0; i<optionsLabels.size(); i++)
		{
			switch(i)
			{
			case 1:
				int index1=i;
				ImageIcon icon1= new ImageIcon("assets"+File.separator+"imagesOptions"+File.separator+index1+"_gray.png");
				ImageIcon icona1= new ImageIcon("assets"+File.separator+"imagesOptions"+File.separator+index1+".png");
				optionsLabels.get(i).addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						optionsLabels.get(index1).setIcon(icona1);
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						optionsLabels.get(index1).setIcon(icon1);
					}
					
					@Override
					public void mouseExited(MouseEvent e) {}					
					@Override
					public void mouseEntered(MouseEvent e) {
						
					}					
					@Override
					public void mouseClicked(MouseEvent e) {}
				});
				break;
			case 2:
				int index2=i;
				ImageIcon icon2= new ImageIcon("assets"+File.separator+"imagesOptions"+File.separator+index2+"_gray.png");
				ImageIcon icona2= new ImageIcon("assets"+File.separator+"imagesOptions"+File.separator+index2+".png");
				optionsLabels.get(i).addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						optionsLabels.get(index2).setIcon(icona2);
					}					
					@Override
					public void mousePressed(MouseEvent e) {
						Scene.difficoltyTwo=true;
						optionsLabels.get(index2).setIcon(icon2);
					}
					
					@Override
					public void mouseExited(MouseEvent e) {}					
					@Override
					public void mouseEntered(MouseEvent e) {}					
					@Override
					public void mouseClicked(MouseEvent e) {}
				});
				break;
			default:
				break;
			}
		}
	}
	
	public Options() {
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(5,1));
		optionsLabels=new ArrayList<JLabel>();
		for(int i=0; i<2; i++)
		{
			ImageIcon img=new ImageIcon("assets"+File.separator+"imagesOptions"+File.separator+i+".png");
			optionsLabels.add(new JLabel(img));
		}
		
//		nope=new ImageIcon("assets"+File.separator+"imagesOptions"+File.separator+"multiplayer_no.png");
//		yes=new ImageIcon("assets"+File.separator+"imagesOptions"+File.separator+"multiplayer_yes.png");
//		optionsLabels.add(new JLabel(nope));
		
		for(int i=0; i<optionsLabels.size(); i++)
		{
			this.add(optionsLabels.get(i));
		}		
		
		//back
		JPanel backbutton=new JPanel();
		backbutton.setLayout(new BorderLayout());
		backbutton.setBackground(Color.BLACK);
		JButton back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Graphic.setPanel(Graphic.getMenu());				
			}
		});
		backbutton.add(back,BorderLayout.PAGE_END);
		this.add(backbutton);
		addListener();
	}
}