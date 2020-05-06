package level;

import graphics.Screen;
import level.tile.Tile;

public abstract class Level {
	protected int ancho;
	protected int alto;
	protected int[] tiles;
	protected Tile[] tileList;

	public Level(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		tiles = new int[ancho * alto];

		generateLevel();
	}

	public Level(String ruta) {
		loadLevel(ruta);
		generateLevel();

	}

	protected void loadLevel(String ruta) {

	}

	protected void generateLevel() {

	}

	public void actualizar() {
	}

	public void show(int compensacionX, int compensacionY, Screen screen) {

		screen.setDifference(compensacionX, compensacionY);

		int x0 = compensacionX >> 5;
		int x1 = (compensacionX + screen.getAncho() + 32) >> 5;
		int y0 = compensacionY >> 5;
		int y1 = (compensacionY + screen.getAlto() + 32) >> 5;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				// getTile(x, y).show(x, y, screen);
				if (x < 0 || y < 0 || x >= ancho || y >= alto) {
					Tile.Empty.show(x, y, screen);
				} else {
					tileList[x + y * ancho].show(x, y, screen);
				}
			}
		}
	}

	public Tile getTile(final int x, final int y) {
		if (x < 0 || y < 0 || x >= ancho || y >= alto) {
			return Tile.Empty;
		}
		switch (tiles[x + y * ancho]) {
		case 0:
			return Tile.RoadUP;
		case 1:
			return Tile.RoadLEFT;
		case 2:
			return Tile.RoadCENTER;
		case 3:
			return Tile.RoadRIGHT;
		case 4:
			return Tile.Sand;
		case 5:
			return Tile.SandTinyRock;
		case 6:
			return Tile.SandBigRock;
		case 7:
			return Tile.SandCactus;
		case 8:
			return Tile.SandTinyBush;
		case 9:
			return Tile.SandTinyCactus;
		case 10:
			return Tile.SandRoadUP;
		case 11:
			return Tile.SandRoadLEFT;
		default:
			return Tile.Empty;
		}

	}

}
