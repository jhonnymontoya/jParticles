/**
 * 
 */
package app.jhonnymontoya.jParticles.forms;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.Timer;

import app.jhonnymontoya.jParticles.Common;

/**
 * 
 */
public class Canvas extends JPanel implements ActionListener, ComponentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3645856309417573045L;
	
	private final int NUMBER_BALLS = 30;
	
	private int canvasWidth = 0;
	private int canvasHeight = 0;
	
	Timer timer = null;
	Map<Object, Object> hints;
	
	List<Ball> balls = new ArrayList<Ball>();
	

	public Canvas(int width, int height) {
		this.canvasWidth = width;
		this.canvasHeight = height;
		
		this.hints = new HashMap<Object, Object>();
		this.hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.hints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		this.hints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		this.hints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		this.hints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		this.hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		
		for (int i = 0; i < this.NUMBER_BALLS; i++) {
			int randomX = Common.getRandomBetweenTwoNumbers(0, this.canvasWidth);
			int randomY = Common.getRandomBetweenTwoNumbers(0, this.canvasHeight);
			Ball ball = new Ball(randomX, randomY, this.canvasWidth, this.canvasHeight);
			this.balls.add(ball);
		}
		
		this.timer = new Timer(41, this);
		this.timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g.create();
		g2.addRenderingHints(this.hints);
		
		g2.clearRect(0, 0, this.canvasWidth, this.canvasHeight);
		
		this.balls.forEach(ball -> {
			ball.draw(g2);
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
		this.balls.forEach(ball -> {
			ball.move();
		});
	}

	@Override
	public void componentResized(ComponentEvent e) {
		this.canvasWidth = this.getWidth();
		this.canvasHeight = this.getHeight();
		
		this.balls.forEach(ball -> {
			ball.setCanvasBoundsInfo(this.canvasWidth, this.canvasHeight);
		});
		this.repaint();
	}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}

	@Override
	public void componentHidden(ComponentEvent e) {}

}
