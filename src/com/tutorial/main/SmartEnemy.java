package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {
	
	private Handler handler;
    private GameObject player;
	public SmartEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		// TODO Auto-generated constructor stub
		for(int i =0; i<handler.object.size();i++) {
			if(handler.object.get(i).getID()==ID.Player)  player=handler.object.get(i);
		}
		
		
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
		float diffX = x - player.getX()-8;
		float diffY = y - player.getY()-8;
		float distance = (float)(float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		velX= (int) Math.round((-1.0/distance) * diffX);
		velY= (int) Math.round((-1.0/distance) * diffY);
		if(y<=0 || y>=Game.HEIGHT - 32) velY *= -1;
		if(x<=0 || x>=Game.WIDTH -  16) velX *= -1;
		
		handler.addObject(new Trail(x,y,ID.Trail,Color.ORANGE,16,16,0.01f,handler));
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 16, 16);
	}
	@Override
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
