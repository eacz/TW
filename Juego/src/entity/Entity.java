package entity;

import level.Level;

public abstract class Entity {
	protected int y;
	protected int x;
	private boolean eliminated = false;
	protected Level level;

	public void refresh() {
	}

	public void show() {
	}

	public void delete() {
		eliminated = true;
	}

	public int getY() {
		return y;
	}

	public void setY(int yDesp) {
		y += yDesp;
	}

	public int getX() {
		return x;
	}

	public void setX(int xDesp) {
		x += xDesp;
	}

	public boolean getEliminated() {
		return eliminated;
	}

}
