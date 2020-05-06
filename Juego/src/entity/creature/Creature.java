package entity.creature;

import entity.Entity;
import graphics.Sprite;

public abstract class Creature extends Entity {
	protected Sprite sprite;
	protected char direction = 'n';
	protected boolean inMovement = false;

	public void refresh() {
	}

	public void show() {
	}

	public void move(int DespX, int DespY) {
		if (DespX > 0) {
			direction = 'e';
		}
		if (DespX < 0) {
			direction = 'o';
		}
		if (DespY > 0) {
			direction = 's';
		}
		if (DespY < 0) {
			direction = 'n';
		}
		if (!getEliminated()) {
			setX(DespX);
			setY(DespY);
		}
	}

	private boolean inCollision() {
		return false;
	}

	public Sprite getSprite() {
		return sprite;
	}
}
