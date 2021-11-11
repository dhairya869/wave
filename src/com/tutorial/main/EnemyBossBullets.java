package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullets extends GameObject {
	
	private Handler handler;
    Random r = new Random();
	public EnemyBossBullets(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		// TODO Auto-generated constructor stub
		velX=(r.nextInt(5 - -5)+ -5);
		velY=5;
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}
         public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		//if(y<=0 || y>=Game.HEIGHT - 32) velY *= -1;
		//if(x<=0 || x>=Game.WIDTH -  16) velX *= -1;
		if(y>=Game.HEIGHT) handler.removeObject(this);
		handler.addObject(new Trail(x,y,ID.Trail,Color.red,16,16,0.01f,handler));
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
	@Override
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
