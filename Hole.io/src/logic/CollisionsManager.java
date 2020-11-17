package logic;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import settings.*;
import graphic.Scene;

public class CollisionsManager {
	private Rectangle rectangleEnemy, playerOne, playerTwo;

    private ArrayList<HoleLogic> p;
    private enum cmDirection{up,down,left,right,notLeft,notRight,notUp,notDown,up1,down1,left1,right1};
    private cmDirection current=cmDirection.right;
    private int speed=2;
    private Random random = new Random();
    private boolean upRight,upLeft;
    private boolean	downRight,downLeft;
    private boolean leftUp,leftDown;
    private boolean	rightUp,rightDown;
    private int score1,score2;
    private int posEnemy; 
    private int cont,fps;
    private int dX1,dX2,dY1,dY2;
    
    public CollisionsManager(ArrayList<HoleLogic> p){
		//this.e = e;
		this.p = p;
		setValues();
	}
    
    private void setValues() {
    	upRight=false; upLeft=false; 
    	downRight=false; downLeft=false;
    	leftUp=false; leftDown=false; 
    	rightUp=false; rightDown=false;
    	score1=0; score2=0; cont=0;
    }
    
    private void killSinglePlayer() {
    	playerOne = new Rectangle(p.get(0).getX(),p.get(0).getY(),Settings.SQUARE,Settings.SQUARE); 
//		if(Scene.dead==false) {
//			for(int i=0; i<e.size(); i++) {
//				rectangleEnemy=new Rectangle(e.get(i).getX(),e.get(i).getY(),Settings.SQUARE,Settings.SQUARE);
//				if(playerOne.intersects(rectangleEnemy) && (p.get(0).getPoints() < e.get(i).getPoints()) ){//domanda1............................................................................................
//					Sound.death();
//					Scene.dead=true;
//				}
//				
//			}
//		}
		if(Scene.dead) {
			Sound.gameStop();
			while(Sound.death.getFramePosition()!=Sound.death.getFrameLength() && Sound.death.isRunning()) {}// do tempo al suono ri riprodursi.
        	JOptionPane.showMessageDialog(null, "GAMEOVER!");
        	Scene.returnToMenu();
        }
    }
    
    
    public void kill()
    {

    		killSinglePlayer();
   }
    
    private void eatSinglePlayer(int [][]levelmap) {
    	playerOne = new Rectangle(p.get(0).getX(),p.get(0).getY(),Settings.CELL_SIZE,Settings.CELL_SIZE);
    	for(int i=0; i<Scene.fruit.size(); i++) {
    		if(playerOne.intersects(Scene.fruit.get(i))) {
    			Sound.nomNom();
    			double xx=  Scene.fruit.get(i).getX(); int xxx=(int) xx;
    			double yy=  Scene.fruit.get(i).getY(); int yyy=(int) yy;
				levelmap[yyy/Settings.SIZE][xxx/Settings.SIZE]=1;
				score1+=100;
				Scene.fruit.remove(Scene.fruit.get(i));
			//	if (score%100)
    		}
    	} 
    	if(Scene.fruit.isEmpty())
		{    		
			JOptionPane.showMessageDialog(null, "YOU WIN!"+"\n"+"Score: "+score1);    			
			Scene.returnToMenu();
		}
	}    	
    
   
    public void eat(int [][]levelmap) {
    	 
    		eatSinglePlayer(levelmap);
    }
     
}