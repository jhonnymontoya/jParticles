/**
 * 
 */
package app.jhonnymontoya.jParticles.forms;

import java.awt.Graphics2D;

import app.jhonnymontoya.jParticles.Common;

/**
 * 
 */
public class Ball {

	private String uuid;
	
	private int canvasWidth;
	
	private int canvasHeight;
	
	private int x;
	
	private int y;
	
	private int radius;
	
	private float dirX;
	
	private float dirY;
	
	private float vel;

	public Ball(int x, int y, int canvasWidth, int canvasHeight) {
		super();
		this.setCanvasBoundsInfo(canvasWidth, canvasHeight);
		this.x = x;
		this.y = y;
		
		this.uuid = Common.getUUID();
		this.radius = Common.getRandomBetweenTwoNumbers(5, 25);
		this.vel = Common.getRandomBetweenTwoNumbers(1, 3);
		this.dirX = Common.getRandomBetweenTwoNumbers(-1, 1);
		this.dirY = Common.getRandomBetweenTwoNumbers(-1, 1);
	}
	
	public String getUuid() {
		return uuid;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setCanvasBoundsInfo(int width, int height) {
		this.canvasWidth = width;
		this.canvasHeight = height;
	}
	
	public void draw(Graphics2D g) {
		int diameter = this.radius * 2;
		g.fillOval(this.x - this.radius, this.y - this.radius, diameter, diameter);
	}
	
	public void move() {
		this.x += this.dirX * this.vel;
		this.y += this.dirY * this.vel;
		
		if (this.x + this.radius > this.canvasWidth) {
			this.dirX = Math.abs(this.dirX) * -1;
			this.x = this.canvasWidth - this.radius;
		}
		if (this.x - this.radius < 0) {
			this.dirX = Math.abs(this.dirX);
		}
		
		if (this.y + this.radius > this.canvasHeight) {
			this.dirY = Math.abs(this.dirY) * -1;
			this.y = this.canvasHeight - this.radius;
		}
		if (this.y - this.radius < 0) {
			this.dirY = Math.abs(this.dirY);
		}
	}
	
}
