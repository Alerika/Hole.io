package logic;

import javax.swing.*;
import javax.swing.JOptionPane;
import graphic.Scene;
import settings.Settings;
import java.io.File;
import java.awt.*;

public class HoleLogic{
	private String right_icon;
	private String left_icon;
	private String up_icon;
	private String down_icon;
	private int points = 0;
	    
	public enum Direction{up,down,left,right};
	private Direction current;
	Direction button;
	int speed;
    private int x;
    private int y;
    private String image;
    private Rectangle rectangleHole;
    
    private void loadImages(int player)
    {
    	right_icon= "assets"+File.separator+"images"+File.separator+"hole_right.png";
    	left_icon= "assets"+File.separator+"images"+File.separator+"hole_left.png";
    	up_icon= "assets"+File.separator+"images"+File.separator+"hole_up.png";
    	down_icon= "assets"+File.separator+"images"+File.separator+"hole_down.png";
    	
    }

    public HoleLogic(int x, int y,int p, String image,int player)
    {	
    	loadImages(player);
    	speed=4;
    	current=Direction.right;
    	button=null;
        setX(x);
        setY(y);
        setImage(image);
        setPoints(p);
    }

    public void setPoints(int points) {this.points = points;}
    boolean canMove(int x,int y) {
    	rectangleHole=new Rectangle(x, y, Settings.CELL_SIZE,Settings.CELL_SIZE);
    	for(Rectangle r: Scene.brick) {
    		if(rectangleHole.intersects(r))
    			return false;
    	}    	
    	return true;
    }
    
    void setX(int x)
    {
    	if(x>450)
    		this.x=0;
    	else if(x<0)
    		this.x=450;
    	else
    		this.x = x;    
    }

    void setY(int y)
    {
    	if(y>450)
    		this.y=0;
    	else if(y<0)
    		this.y=450;
    	else
    		this.y = y;        }

    void setImage(String image)
    {
        if(image == null)
        {
            JOptionPane.showMessageDialog(null, "Image is null");
            System.exit(1);
        }
        else
            this.image = image;
    }

    public void updatePoint(final int points) {this.points += points;}
    public int getPoints() {return points;}
    int getY() {return y;}
    int getX() {return x;}
    String getImage() {return image;}
    
    public void drawHole(Graphics graphics)
    {	
    	switch(current) {
			case up:
				 setImage(up_icon);
				break;
			case down:
				setImage(down_icon);    			
				break;
			case left:
				setImage(left_icon);
				break;
			case right:
				setImage(right_icon);
		}
	
        ImageIcon img = new ImageIcon(image);
        Settings.scaleIcon(img, 35, 35);
        graphics.drawImage(img.getImage(),x,y,null);
    }

    public void updatePosition() {
    	if(button==Direction.left  && canMove(getX()-speed, getY()))
          {	
              if(current!=HoleLogic.Direction.left)
              	  current=HoleLogic.Direction.left;
              	  setX(getX() - speed);
          }
    	
          else if(button==Direction.right && canMove(getX()+speed, getY()))
          {
        	  
        	  if(current!=HoleLogic.Direction.right)
              	  current=HoleLogic.Direction.right;
              	  setX(getX() + speed);
          }
    
          else if(button==Direction.up && canMove(getX(), getY()-speed))
          {
      		
          	if(current!=HoleLogic.Direction.up)
          		current=HoleLogic.Direction.up;
          		setY(getY() - speed);
          }
    	
          else if(button==Direction.down && canMove(getX(), getY()+speed) )
          {
      		
          	if(current!=HoleLogic.Direction.down)
          		current=HoleLogic.Direction.down;
          		setY(getY() + speed);
          }
    }
}