package entity.creature;

import control.Keyboard;
import graphics.Screen;
import graphics.Sprite;

public class Player extends Creature {
	private Keyboard keyboard;
	private int animation;

	public Player(Keyboard keyboard, Sprite sprite) {
		this.keyboard = keyboard;
		this.sprite = sprite;
	}

	public Player(Keyboard keyboard, Sprite sprite, int posX, int posY) {
		this.keyboard = keyboard;
		this.sprite = sprite;
		this.x = posX;
		this.y = posY;
	}

	public void refresh() {
		int DespY = 0;
		int DespX = 0;
		int movementVelocity = 1;

		if (animation < 32767) {
			animation++;
		} else {
			animation = 0;
		}

		if (keyboard.run) {
			movementVelocity = 2;
		}

		if (keyboard.up) {
			DespY -= movementVelocity;
		}
		if (keyboard.down) {
			DespY += movementVelocity;
		}
		if (keyboard.left) {
			DespX -= movementVelocity;
		}
		if (keyboard.right) {
			DespX += movementVelocity;
		}

		if (DespX != 0 || DespY != 0) {
			move(DespX, DespY);
			inMovement = true;
		} else {
			inMovement = false;
		}
		int remainder = animation % 40;

		if (direction == 'n') {
			sprite = Sprite.Back0;
			if (inMovement) {
				if (remainder > 10 && remainder <= 20) {
					sprite = Sprite.Back1;
				} else if (remainder > 20 && remainder <= 30) {
					sprite = Sprite.Back0;
				} else if (remainder > 30) {
					sprite = Sprite.Back2;
				} else {
					sprite = Sprite.Back0;
				}
			}
		}
		if (direction == 's') {
			sprite = Sprite.Front0;
			if (inMovement) {
				if (remainder > 10 && remainder <= 20) {
					sprite = Sprite.Front1;
				} else if (remainder > 20 && remainder <= 30) {
					sprite = Sprite.Front0;
				} else if (remainder > 30) {
					sprite = Sprite.Front2;
				} else {
					sprite = Sprite.Front0;
				}
			}
		}
		if (direction == 'e') {
			sprite = Sprite.Right0;
			if (inMovement) {
				if (remainder > 10 && remainder <= 20) {
					sprite = Sprite.Right1;
				} else if (remainder > 20 && remainder <= 30) {
					sprite = Sprite.Right0;
				} else if (remainder > 30) {
					sprite = Sprite.Right2;
				} else {
					sprite = Sprite.Right0;
				}
			}
		}
		if (direction == 'o') {
			sprite = Sprite.Left0;
			if (inMovement) {
				if (remainder > 10 && remainder <= 20) {
					sprite = Sprite.Left1;
				} else if (remainder > 20 && remainder <= 30) {
					sprite = Sprite.Left0;
				} else if (remainder > 30) {
					sprite = Sprite.Left2;
				} else {
					sprite = Sprite.Left0;
				}

			}
		}

		/*
		 * switch (direction) { case 'n': sprite = Sprite.Back0; break; case 's': sprite
		 * = Sprite.Front0; break; case 'e': sprite = Sprite.Right0; break; case 'o':
		 * sprite = Sprite.Left0; break; }
		 */
	}

	public void show(Screen screen) {
		screen.showPlayer(x, y, this);
	}

}
