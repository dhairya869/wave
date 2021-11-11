package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {
	
	private Handler handler;
	Random r = new Random();
    private int timer = 60;
    private int timer2 = 40;
	public EnemyBoss(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		// TODO Auto-generated constructor stub
		velX=0;
		velY=2;
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}
         public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if(timer <= 0)  velY=0;
		else timer--;
		if(timer<=0) timer2--;
		if(timer2 <= 0)
		{
			if(velX==0) velX=2;
			
			if(velX>0)
			velX += 0.05f;
			else if(velX<0)
			velX -= 0.05f;
			
			
			velX = Game.clamp(velX, -10, 10);
			
			int spawn = r.nextInt(10);
			if(spawn==0) handler.addObject(new EnemyBossBullets(x+15,y+15,ID.BasicEnemy,handler));
		}
		//if(y<=0 || y>=Game.HEIGHT - 32) velY *= -1;
		if(x<=0 || x>=Game.WIDTH -  16) velX *= -1;
		
		//handler.addObject(new Trail(x,y,ID.Trail,Color.red,64,64,0.008f,handler));
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect(x, y, 64, 64);
	}
	@Override
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
