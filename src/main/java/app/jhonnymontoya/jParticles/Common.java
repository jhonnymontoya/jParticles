/**
 * 
 */
package app.jhonnymontoya.jParticles;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.GraphicsDevice;
import java.util.UUID;

import app.jhonnymontoya.jParticles.forms.Ball;

import java.util.Random;

/**
 * 
 */
public class Common {
	
	/**
	 * Gets the screen devices
	 * @return
	 */
	private static GraphicsDevice[] getScreenDevices() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
	}
	
	/**
	 * Gets the number of screens installed
	 * @return number of screens
	 */
	public static int getNumberOfScreens() {
		return Common.getScreenDevices().length;
	}
	
	/**
	 * Gets the bounds of the screen by id
	 * @param screenId, ID of the screen to select
	 * @return A rectangle with the dimensions of the screen 
	 */
	public static Rectangle getScreenBounds(int screenId) {
		GraphicsDevice[] screens = Common.getScreenDevices();
		GraphicsDevice screen = screens[screenId];
		Rectangle bounds = screen.getDefaultConfiguration().getBounds();
		return bounds;
	}
	
	public static Rectangle getMainScreenBounds() {
		GraphicsDevice[] screens = Common.getScreenDevices();
		GraphicsDevice mainScreen = null;
		
		for(GraphicsDevice screen : screens) {
			Rectangle bounds = screen.getDefaultConfiguration().getBounds();
			if (bounds.x == 0 && bounds.y == 0) {
				mainScreen = screen;
				break;
			}
		}
		
		if (mainScreen == null) {
			mainScreen = Common.getScreenDevices()[0];
		}
		
		return mainScreen.getDefaultConfiguration().getBounds();
	}
	
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	public static int getRandomBetweenTwoNumbers(int min, int max) {
		int randomNumber = 0;
		do {
			randomNumber = new Random().nextInt(max - min + 1) + min;
		}
		while(randomNumber == 0);
		return randomNumber;
	}
	
	public static int getDistance(Ball ball, Ball ball2) {
		int deltaX = ball2.getX() - ball.getX();
		int deltaY = ball2.getY() - ball.getY();
		return (int)Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
	}
	
}
