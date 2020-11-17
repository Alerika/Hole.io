package settings;

import java.io.*;
import javax.sound.sampled.*;   

public class Sound {
    private AudioInputStream sound1,sound2,sound3,sound4,sound5;
    public static Clip nomnom,death,menu,game,intro;
	
   public Sound() {   
      try {
         sound1= AudioSystem.getAudioInputStream(new File("assets"+File.separator+"sounds"+File.separator+"nomnom.wav"));
         sound2= AudioSystem.getAudioInputStream(new File("assets"+File.separator+"sounds"+File.separator+"death.wav"));
         sound3= AudioSystem.getAudioInputStream(new File("assets"+File.separator+"sounds"+File.separator+"newGame.wav"));
         sound4= AudioSystem.getAudioInputStream(new File("assets"+File.separator+"sounds"+File.separator+"menu.wav"));
         sound5= AudioSystem.getAudioInputStream(new File("assets"+File.separator+"sounds"+File.separator+"game.wav"));
         nomnom = AudioSystem.getClip();
         death = AudioSystem.getClip();
         intro = AudioSystem.getClip();
         menu = AudioSystem.getClip();
         game = AudioSystem.getClip();
         nomnom.open(sound1);
         death.open(sound2);
         intro.open(sound3);
         menu.open(sound4);
         game.open(sound5);
      } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			nomnom=null; death=null; intro=null; menu = null; game =null;
			e.printStackTrace();
		}	
   }
   public static void nomNom() {
	   if(nomnom != null) {
			if(nomnom.getFramePosition() == nomnom.getFrameLength())
				nomnom.setFramePosition(0);
			nomnom.start();			
		}
   }
   public static void nomNomStop() {
	   if(nomnom != null) {
			nomnom.stop();
		}
   }
   public static void death() {
	   if(death != null) {
			if(death.getFramePosition() == death.getFrameLength())
				death.setFramePosition(0);
			death.start();			
		}
   }
   public static void deathStop() {
	   if(death != null) {
			death.stop();
		}
   }
   public static void newGame() {
	   if(intro != null) {
			if(intro.getFramePosition() == intro.getFrameLength())
				intro.setFramePosition(0);
			intro.start();			
		}
   }
   public static void newGameStop() {
	   if(intro != null) {
		   intro.stop();
		}
   } 
   public static void Menu() {
	   if(menu != null) {
			if(menu.getFramePosition() == menu.getFrameLength())
				menu.setFramePosition(0);
			menu.loop(Clip.LOOP_CONTINUOUSLY);	
		}
   }
   public static void MenuStop() {
	   if(menu != null) {
			menu.stop();
		}
   } 
   
   public static void Game() {
	   if(game != null) {
			if(game.getFramePosition() == game.getFrameLength())
				game.setFramePosition(0);
			game.loop(Clip.LOOP_CONTINUOUSLY);	
		}
   }
   public static void gameStop() {
	   if(game != null) {
			game.stop();
		}
   } 
}