package graphics;

import entity.creature.Player;
import level.tile.Tile;

public final class Screen {
	private final int ancho;
	private final int alto;
	private int differenceX;
	private int differenceY;
	public final int[] pixels;

	public Screen(final int ancho, final int alto) {
		this.alto = alto;
		this.ancho = ancho;

		pixels = new int[ancho * alto];

	}

	public void clean() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	// show

	public void showTile(int compX, int compY, Tile tile) {
		compX -= differenceX;
		compY -= differenceY;

		for (int y = 0; y < tile.sprite.getLado(); y++) {
			int posY = y + compY;
			for (int x = 0; x < tile.sprite.getLado(); x++) {
				int posX = x + compX;
				if (posX < -tile.sprite.getLado() || posX >= ancho || posY < 0 || posY >= alto) {
					break;
				}
				if (posX < 0) {
					posX = 0;
				}
				pixels[posX + posY * ancho] = tile.sprite.pixels[x + y * tile.sprite.getLado()];
			}
		}
	}

	public void showPlayer(int compX, int compY, Player player) {

		compX -= differenceX;
		compY -= differenceY;

		for (int y = 0; y < player.getSprite().getLado(); y++) {
			int posY = y + compY;
			for (int x = 0; x < player.getSprite().getLado(); x++) {
				int posX = x + compX;
				if (posX < -player.getSprite().getLado() || posX >= ancho || posY < 0 || posY >= alto) {
					break;
				}
				if (posX < 0) {
					posX = 0;
				}

				// pixels[posX + posY * ancho] = player.getSprite().pixels[x + y *
				// player.getSprite().getLado()];
				int pixelColorPlayer = player.getSprite().pixels[x + y * player.getSprite().getLado()];
				if (pixelColorPlayer != 0xffff00ff) {
					pixels[posX + posY * ancho] = pixelColorPlayer;
				}
			}
		}
	}

	public void setDifference(final int differenceX, final int differenceY) {
		this.differenceX = differenceX;
		this.differenceY = differenceY;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}
