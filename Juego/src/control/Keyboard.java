package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Keyboard implements KeyListener {
	private final static int keynumb = 120;
	private boolean[] keys = new boolean[keynumb];

	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public boolean esc;
	// public boolean sneak;
	public boolean run;

	public void actualizar() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		run = keys[KeyEvent.VK_SHIFT];
		esc = keys[KeyEvent.VK_ESCAPE];
		// sneak=keys[KeyEvent.VK_CONTROL];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
