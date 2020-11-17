package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Credits extends JPanel{
	private JLabel creditsLabel;
	
	public Credits() {
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		ImageIcon image = new ImageIcon("assets"+File.separator+"imagesMenu"+File.separator+"credits_label.png");
		creditsLabel=new JLabel(image);
		
		JButton back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Graphic.setPanel(Graphic.getMenu());
				
			}
		});
		this.add(creditsLabel, BorderLayout.CENTER);
		this.add(back, BorderLayout.PAGE_END);
	}
}