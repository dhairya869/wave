package com.tutorial.main;

import java.util.Random;

public class Spawn {

	 private Handler handler;
	 private HUD hud;
	 private int scorekeep = 0;
	 private Random r = new Random();
	 public Spawn(Handler handler,HUD hud) {
	 this.handler = handler;
	 this.hud = hud;
	 }
	 public void tick()	 {
	 scorekeep++;
	 if(scorekeep >=100) {
		 scorekeep=0;
		 hud.setlevel(hud.getlevel()+1);
		 
		 if(hud.getlevel()==2) {
			 handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
		 } else if(hud.getlevel()==3) {
				 handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
				 handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
			 }else if(hud.getlevel()==4) {
				 handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy,handler));
			 }else if(hud.getlevel()==5) {
				 handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			 }else if(hud.getlevel()==10) {
				 handler.clearEnemies();
				 handler.addObject(new EnemyBoss((Game.WIDTH/2)-48,-120,ID.EnemyBoss,handler));
				
				 
		 }   	 
}
}}