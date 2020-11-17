package logic;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import graphic.Scene;
import java.awt.event.KeyListener;
import settings.Sound;

public class KeyEvents implements KeyListener {
    private ArrayList<HoleLogic> p;
   
    public KeyEvents(ArrayList<HoleLogic> p)
    {
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

	@Override
    public void keyPressed(KeyEvent e) {
    	
    	if(p.size()==2) {
    	//////PLAYER1
	        if(e.getKeyCode() == KeyEvent.VK_LEFT && p.get(0).canMove(p.get(0).getX()-p.get(0).speed, p.get(0).getY()) )
	        {	
	        	p.get(0).button=HoleLogic.Direction.left;
	        }
	        
	        else if(e.getKeyCode() == KeyEvent.VK_RIGHT && p.get(0).canMove(p.get(0).getX()+p.get(0).speed, p.get(0).getY()))
	        {
	        	p.get(0).button=HoleLogic.Direction.right;
	        }
	        
	        else if(e.getKeyCode() == KeyEvent.VK_UP && p.get(0).canMove(p.get(0).getX(), p.get(0).getY()-p.get(0).speed   ))
	        {
	        	p.get(0).button=HoleLogic.Direction.up;
	        }
	
	        else if(e.getKeyCode() == KeyEvent.VK_DOWN && p.get(0).canMove(p.get(0).getX(), p.get(0).getY()+p.get(0).speed  ) )
	        {
	        	p.get(0).button=HoleLogic.Direction.down;
	        }
        
        //////PLAYER2
	        if(e.getKeyCode() == KeyEvent.VK_A && p.get(1).canMove(p.get(1).getX()-p.get(1).speed, p.get(1).getY()) )
	        {	
	        	p.get(1).button=HoleLogic.Direction.left;
	        }
	        
	        else if(e.getKeyCode() == KeyEvent.VK_D && p.get(1).canMove(p.get(1).getX()+p.get(1).speed, p.get(1).getY()))
	        {
	        	p.get(1).button=HoleLogic.Direction.right;
	        }
	        
	        else if(e.getKeyCode() == KeyEvent.VK_W && p.get(1).canMove(p.get(1).getX(), p.get(1).getY()-p.get(1).speed   ))
	        {
	        	p.get(1).button=HoleLogic.Direction.up;
	        }
	
	        else if(e.getKeyCode() == KeyEvent.VK_S && p.get(1).canMove(p.get(1).getX(), p.get(1).getY()+p.get(1).speed ))
	        {
	        	p.get(1).button=HoleLogic.Direction.down;
	        }
    	}
    	else {
    		if(e.getKeyCode() == KeyEvent.VK_LEFT && p.get(0).canMove(p.get(0).getX()-p.get(0).speed, p.get(0).getY()) )
            {	
            	p.get(0).button=HoleLogic.Direction.left;
            }
            
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT && p.get(0).canMove(p.get(0).getX()+p.get(0).speed, p.get(0).getY()))
            {
            	p.get(0).button=HoleLogic.Direction.right;
            }
            
            else if(e.getKeyCode() == KeyEvent.VK_UP && p.get(0).canMove(p.get(0).getX(), p.get(0).getY()-p.get(0).speed   ))
            {
            	p.get(0).button=HoleLogic.Direction.up;
            }

            else if(e.getKeyCode() == KeyEvent.VK_DOWN && p.get(0).canMove(p.get(0).getX(), p.get(0).getY()+p.get(0).speed  ) )
            {
            	p.get(0).button=HoleLogic.Direction.down;
            }
    	}
         /////ESC
         if(e.getKeyCode()==KeyEvent.VK_ESCAPE && Sound.intro.isRunning()==false) {
        	Scene.returnToMenu();
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}