package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {
	
	private Handler handler;

	public FastEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		// TODO Auto-generated constructor stub
		velX=2;
		velY=8;
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}
         public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if(y<=0 || y>=Game.HEIGHT - 32) velY *= -1;
		if(x<=0 || x>=Game.WIDTH -  16) velX *= -1;
		
		handler.addObject(new Trail(x,y,ID.Trail,Color.CYAN,16,16,0.01f,handler));
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.CYAN);
		g.fillRect(x, y, 16, 16);
	}
	@Override
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
