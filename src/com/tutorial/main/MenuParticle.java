package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject 
{
	private Handler handler;
    Random r = new Random();
    private Color col;
	public MenuParticle(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		// TODO Auto-generated constructor stub
		velX=(int) (r.nextFloat()*(r.nextInt((5- -5)+ -5)+1)*3);
		velY=(int) (r.nextFloat()*(r.nextInt((5- -5)+ -5)+1)*3);
		if(velX==0) velX=1;
		if(velY==0) velY=1;
		col = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
		
	
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
		
		handler.addObject(new Trail(x,y,ID.Trail,col,16,16,0.05f,handler));
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(col);
		g.fillRect(x, y, 16, 16);
	}
	@Override
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
