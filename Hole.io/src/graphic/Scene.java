package graphic;

import javax.swing.*;
import logic.CollisionsManager;
import logic.KeyEvents;
import logic.Map;
import logic.HoleLogic;
import settings.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
    public static ArrayList<Rectangle> brick;
    public static ArrayList<Rectangle> fruit;
    //public static ArrayList <Enemy> enemy;
    public static ArrayList <HoleLogic> hole;
    public KeyEvents keyEvents;
    private CollisionsManager c;
    public Map p;
    public static boolean dead;
    public static boolean difficoltyTwo;
    //public static boolean addSecondPacman,notAddSecondPacman;
    private Thread panel;
    public static boolean stopGame,runGame;
    
    private void setValues()
    {
    	dead=false; 
    	difficoltyTwo=false;
    	stopGame=false; runGame=false;
    }
    
    public Scene()
    {
    	setValues();
    	brick = new ArrayList<Rectangle>();
    	fruit = new ArrayList<Rectangle>();
        //enemy = new ArrayList<Enemy>();
        hole = new ArrayList<HoleLogic>();
    	p = new Map();
    	if(p.levelmap.length==0)
    		System.out.println("levelmap empty(?)");
    }
   
    public static void returnToMenu() {
    	 Graphic.setScene(new Scene());
    	 stopGame=true;
    	 runGame=false;
    	 Sound.gameStop();
    	 Sound.game.setFramePosition(0);
    	 Sound.intro.setFramePosition(Sound.intro.getFrameLength());
    	 Graphic.setMenu(new Menu());
    	 Graphic.setOptions(new Options());
    	 Graphic.setCredits(new Credits());
		 Graphic.setPanel(Graphic.getMenu());
    }

     void game(String s) {
    	this.setBackground(Color.BLACK);
    	p.readmap(s);
    	runGame=true;
    	
    	c = new CollisionsManager(hole);
    	keyEvents = new KeyEvents(hole);
    	
        Sound.newGame();

        panel = new Thread(this);
        panel.start();
    }
   
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	p.Drawmap(g); 
    	if(hole.size()==2) {
	    	if(dead==false)
	    		hole.get(0).drawHole(g);
    	}
    	else if(hole.size()==1) {
    		if(dead==false)
    	    	hole.get(0).drawHole(g);
    	}
    }
  
     
    @Override
	public void run() {
		while(!stopGame) {
			while(Sound.intro.getFramePosition()!=Sound.intro.getFrameLength()) { // fin quando c'è l'intro i nemici rimangono fermi.
				//enemyBlock();
			}			
			Sound.Game();
			if(stopGame==false)
			{
				if(hole.size()==2) 
				{
					if(dead==false) hole.get(0).updatePosition();
				}
				else if(hole.size()==1)
					hole.get(0).updatePosition();
				
				c.eat(p.levelmap);
				c.kill();

		        //followIntelligente();
				repaint();				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
			}
		}
    }
}