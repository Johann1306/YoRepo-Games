package tests.front;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelTitreMP3 extends JPanel {

	private String message;
	private Color color = Color.WHITE;
	private int fontSize = 10;
	private int x = 0;
	private int y = 10;
	
	public PanelTitreMP3(String message) {
		this.message = message;
	}
	
	public PanelTitreMP3(String message, Color color, int fontSize, int x, int y) {
		this.message = message;
		this.color = color;
		this.fontSize = fontSize;
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
		Dimension d = new Dimension(500, 10);
		this.setSize(d);
//		this.setOpaque(false);
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		g.setFont(new Font("Press Start", Font.PLAIN, fontSize));
		g.setColor(color);
		g.drawString(message, x, y);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}