package Juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import control.Keyboard;
import entity.creature.Player;
import graphics.Screen;
import graphics.Sprite;
import level.Level;
import level.LoadedLevel;

public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static JFrame ventana;
	private static final int ancho = 400;
	private static final int alto = 300;
	private static final String nombre = "The Wastelander";
	private static String FPS = "";
	private static String APS = "";
	private static int fps = 0;
	private static int aps = 0;
	private static Thread ilo;
	private static volatile boolean EnFuncionamiento = false;
	private static Keyboard keyboard;
	private static Screen screen;

	private static Level level;
	private static Player player;

	private static BufferedImage img = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
	private static int[] pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
	private static final ImageIcon logo = new ImageIcon(Juego.class.getResource("/logo/logo.png"));

	private Juego() {
		setPreferredSize(new Dimension(ancho, alto));

		screen = new Screen(ancho, alto);

		// level = new GeneratedLevel(32, 32);
		keyboard = new Keyboard();
		level = new LoadedLevel("/levels/map1pixel.png");
		player = new Player(keyboard, Sprite.Front0, 640, 420);
		addKeyListener(keyboard);

		ventana = new JFrame(nombre);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setIconImage(logo.getImage());
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.setUndecorated(true);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.start();
	}

	private synchronized void start() {
		EnFuncionamiento = true;

		ilo = new Thread(this, "graphics");
		ilo.start();

	}

	private synchronized void stop() {
		EnFuncionamiento = false;
		try {
			ilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void refresh() {
		keyboard.actualizar();
		player.refresh();

		if (keyboard.esc) {
			System.exit(0);
		}
		aps++;
	}

	public void show() {
		BufferStrategy strategy = getBufferStrategy();

		if (strategy == null) {
			createBufferStrategy(3);
			return;
		}
		// screen.clean();
		level.show(player.getX() - screen.getAncho() / 2 + player.getSprite().getLado() / 2,
				player.getY() - screen.getAlto() / 2 + player.getSprite().getLado() / 2, screen);
		player.show(screen);
		System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);
//		for (int i = 0; i < pixels.length; i++) {
//			pixels[i] = screen.pixels[i];
//		}
		Graphics g = strategy.getDrawGraphics();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.white);
		g.drawString(FPS, 10, 20);
		g.drawString(APS, 10, 35);
		g.drawString("x: " + player.getX(), 10, 50);
		g.drawString("y: " + player.getY(), 10, 65);
		g.dispose();
		strategy.show();
		fps++;
	}

	@Override
	public void run() {
		final int nseg = 1000000000;
		final byte apsob = 60;
		final double nxact = nseg / apsob;
		long referencact = System.nanoTime();
		long referenccount = System.nanoTime();
		double timetrans;
		double delta = 0;
		requestFocus();

		while (EnFuncionamiento) {
			final long startloop = System.nanoTime();
			timetrans = startloop - referencact;
			referencact = startloop;
			delta += timetrans / nxact;
			while (delta >= 1) {
				refresh();
				delta--;
			}

			show();

			if (System.nanoTime() - referenccount > nseg) {

				APS = "APS: " + aps;
				FPS = "FPS: " + fps;
				aps = 0;
				fps = 0;
				referenccount = System.nanoTime();
			}

		}

	}
}
