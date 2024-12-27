/**
 * 
 */
package app.jhonnymontoya.jParticles.forms;

import java.awt.HeadlessException;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import app.jhonnymontoya.jParticles.Common;

/**
 * 
 */
public class MainForm extends JFrame {

	private static final long serialVersionUID = -8584768835443350206L;
	
	private final int WIDTH = 1300;
	private final int HEIGHT = 800;

	private Canvas canvas = null;

	public MainForm() throws HeadlessException {
		super("Particles");
		this.setFormBounds(this.WIDTH, this.HEIGHT);
		this.loadIcon();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.canvas = new Canvas(this.WIDTH, this.HEIGHT);
		this.add(this.canvas);
		
		this.addComponentListener(this.canvas);
	}
	
	private void setFormBounds(int width, int height) {
		Rectangle mainScreenBounds = Common.getMainScreenBounds();
		Rectangle bounds = new Rectangle(
					(mainScreenBounds.width - width) / 2, // x
					(mainScreenBounds.height - height) / 2, // y
					width, // with
					height // height
				);
		this.setBounds(bounds);
	}
	
	private void loadIcon() {
		String resource = "icons/particles.png";
		ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource(resource));
		this.setIconImage(icon.getImage());
	}

}
