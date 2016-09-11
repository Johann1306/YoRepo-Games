package tests.front;

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author fabriceb
 */
public class Scroller extends JPanel implements MouseInputListener {

	private static final long serialVersionUID = 1l;
	private int nbTile = 1;
	private BufferedImage[] imTile = new BufferedImage[nbTile];
	private int[] xTile = new int[nbTile];
	private int[] yTile = new int[nbTile];
	int dx, dy;
	int tileWidth, tileHeight;
	int anchorX, anchorY;
	int areaHeight, areaWidth;

	public Scroller() throws IOException {
		super();
		BufferedImage imageSrc = ImageIO.read(new File("src/main/resources/image/carte/montfermeil.png"));
		tileWidth = imageSrc.getWidth();
		tileHeight = imageSrc.getHeight();
		// Promote image for some acceleration.
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		BufferedImage image = gc.createCompatibleImage(tileWidth, tileHeight, imageSrc.getTransparency());
		Graphics2D g2d = image.createGraphics();
		g2d.drawImage(imageSrc, 0, 0, null);
		g2d.dispose();
		// Layout tiles.
		int sideX = (int) Math.ceil(Math.sqrt(nbTile));
		int sideY = (int) Math.ceil(nbTile / (float) sideX);
		int index = 0;
		for (int j = 0; j < sideY && index < nbTile; j++) {
			for (int i = 0; i < sideX && index < nbTile; i++, index++) {
				imTile[index] = image;
				xTile[index] = i * tileWidth;
				yTile[index] = j * tileHeight;
			}
		}
		areaWidth = sideX * tileWidth;
		areaHeight = sideY * tileHeight;
		System.out.println("Area:");
		System.out.println("\tTiles: " + nbTile);
		System.out.println("\tLayout: " + sideX + " x " + sideY);
		System.out.println("\tDimension: " + areaWidth + " x " + areaHeight);
		// Set view on area center.
		dx = -(areaWidth - tileWidth) / 2;
		dy = -(areaHeight - tileHeight) / 2;
		//
		setFont(getFont().deriveFont(Font.BOLD, 15f));
		addMouseListener(this);
		addMouseMotionListener(this);
//		addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent e) {
//				int x = e.getX();
//				int y = e.getY();
//
//				dx = x - 512;
//				dy = -y + 369;
//				repaint();
//			}
//		});
	}

	public Scroller(String background) {
		super();
		BufferedImage imageSrc = null;
		try {
			imageSrc = ImageIO.read(new File(background));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tileWidth = imageSrc.getWidth();
		tileHeight = imageSrc.getHeight();
		// Promote image for some acceleration.
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		BufferedImage image = gc.createCompatibleImage(tileWidth, tileHeight, imageSrc.getTransparency());
		Graphics2D g2d = image.createGraphics();
		g2d.drawImage(imageSrc, 0, 0, null);
		g2d.dispose();
		// Layout tiles.
		int sideX = (int) Math.ceil(Math.sqrt(nbTile));
		int sideY = (int) Math.ceil(nbTile / (float) sideX);
		int index = 0;
		for (int j = 0; j < sideY && index < nbTile; j++) {
			for (int i = 0; i < sideX && index < nbTile; i++, index++) {
				imTile[index] = image;
				xTile[index] = i * tileWidth;
				yTile[index] = j * tileHeight;
			}
		}
		areaWidth = sideX * tileWidth;
		areaHeight = sideY * tileHeight;
		System.out.println("Area:");
		System.out.println("\tTiles: " + nbTile);
		System.out.println("\tLayout: " + sideX + " x " + sideY);
		System.out.println("\tDimension: " + areaWidth + " x " + areaHeight);
		// Set view on area center.
		dx = -(areaWidth - tileWidth) / 2;
		dy = -(areaHeight - tileHeight) / 2;
		//
		setFont(getFont().deriveFont(Font.BOLD, 15f));
		addMouseListener(this);
		addMouseMotionListener(this);
//		addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent e) {
//				int x = e.getX();
//				int y = e.getY();
//
//				dx = x - 512;
//				dy = -y + 369;
//				repaint();
//			}
//		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void paintComponent(Graphics g) {

//		for (int i = 0; i < nbTile; i++) {
//			g2d.drawImage(ImTile[i].getImage(), xTile[i] - dx, yTile[i] + dy, null);
//			xTile[i] = xTile[i] - dx;
//			yTile[i] = yTile[i] + dy;
//
//		}

		super.paintComponent(g);
		Dimension size = getSize();
		Graphics2D g2d = (Graphics2D) g.create();
		try {
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			Font font = g2d.getFont();
			g2d.setColor(Color.BLACK);
			Shape clip = g2d.getClip();
			for (int i = 0; i < nbTile; i++) {
				// Optimised painting.
				// Paint only what is visible.
				if (clip.intersects(dx + xTile[i], dy + yTile[i], imTile[i].getWidth(), imTile[i].getHeight())) {
					g2d.drawImage(imTile[i], dx + xTile[i], dy + yTile[i], null);
					String label = "Tile " + i;
					LineMetrics lineMetrics = font.getLineMetrics(label, g2d.getFontRenderContext());
					g2d.drawString(label, dx + xTile[i], dy + yTile[i] + lineMetrics.getAscent());
				} else {
					// System.out.println("Tile " + i + " outside of bounds :
					// not painted.");
				}
			}
			String label = "dx: " + dx + ", dy: " + dy;
			Rectangle2D labelBounds = font.getStringBounds(label, g2d.getFontRenderContext());
			LineMetrics lineMetrics = font.getLineMetrics(label, g2d.getFontRenderContext());
			g2d.setColor(new Color(128, 128, 255, 128));
			g2d.fillRect(0, size.height - (int) labelBounds.getHeight(), (int) labelBounds.getWidth(),
					(int) labelBounds.getHeight());
			g2d.setColor(Color.BLACK);
			g2d.drawString(label, 0, size.height - (float) labelBounds.getHeight() + lineMetrics.getAscent());
		} finally {
			g.dispose();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isMiddleMouseButton(e)) {
			dx = -(areaWidth - tileWidth) / 2;
			dy = -(areaHeight - tileHeight) / 2;
			repaint();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		anchorX = e.getX();
		anchorY = e.getY();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		Dimension size = getSize();
		int dx = this.dx + e.getX() - anchorX;
		int dy = this.dy + e.getY() - anchorY;
		dx = Math.min(dx, 0);
		dx = Math.max(dx, -(areaWidth - size.width));
		dy = Math.min(dy, 0);
		dy = Math.max(dy, -(areaHeight - size.height));
		anchorX = e.getX();
		anchorY = e.getY();
		this.dx = dx;
		this.dy = dy;
		repaint();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		SwingUtilities.invokeLater(new Runnable() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				try {
					Scroller scroller = new Scroller();
					JFrame frame = new JFrame("Test");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLayout(new BorderLayout());
					frame.add(scroller, BorderLayout.CENTER);
					frame.setSize(500, 500);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}