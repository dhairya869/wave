package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	 
	LinkedList<GameObject> object = new LinkedList<GameObject>(); 
    public void tick() {
    	for(int i=0; i< object.size();i++) {
    		GameObject tempObject = object.get(i);
    		
    		tempObject.tick();
    	}
    }
    public void render(Graphics g) {
    	for(int i =0;i<object.size();i++) {
    		GameObject tempObject = object.get(i);
    		
    		tempObject.render(g);
    	}
    }
    public void addObject(GameObject object) {
    	this.object.add(object);
    }
    public void removeObject(GameObject object) {
    	this.object.remove(object);
    }
    public void clearEnemies(){
    	  for(int i = 0; i < object.size(); i++){
    	      GameObject tempObject = object.get(i);

    	      if(Game.gameState != Game.STATE.Game){
    	       object.clear();
    	      }
    	      
    	      if(tempObject.getID() != ID.Player){
    	       removeObject(tempObject);       
    	       i--;
    	      }
    	  }
    	    
    }}