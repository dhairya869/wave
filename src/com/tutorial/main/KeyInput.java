package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	private Handler handler;
	private boolean[] keydown = new boolean[4];
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		keydown[0]=false;
		keydown[1]=false;
		keydown[2]=false;
		keydown[3]=false;
		
	}
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		for(int i =0; i <handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID()==ID.Player) {
				//key event for player1
				if(key == KeyEvent.VK_UP)    {tempObject.setVelY(-5); keydown[0]=true;}
				if(key == KeyEvent.VK_DOWN)  {tempObject.setVelY(5);  keydown[1]=true; }
				if(key == KeyEvent.VK_RIGHT) {tempObject.setVelX(5);  keydown[2]=true ;}
				if(key == KeyEvent.VK_LEFT)  {tempObject.setVelX(-5); keydown[3]=true ;}
			}
			
			
		}
		if(key==KeyEvent.VK_ESCAPE) System.exit(1); 
		
   }
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i =0; i <handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID()==ID.Player) {
				//key event for player1
				if(key == KeyEvent.VK_UP)keydown[0]=false;         //tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN)keydown[1]=false;       //tempObject.setVelY(0);
				if(key == KeyEvent.VK_RIGHT)keydown[2]=false;      //tempObject.setVelX(0);
				if(key == KeyEvent.VK_LEFT)keydown[3]=false;       //tempObject.setVelX(0);
				
				//vertical movement
				if(!keydown[0]&&!keydown[1]) tempObject.setVelY(0);
				//horizontal movement
				if(!keydown[2]&&!keydown[3]) tempObject.setVelX(0);
				
			}
			
}}}