package level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import level.tile.Tile;

public class LoadedLevel extends Level {

	private int[] pixels;

	public LoadedLevel(String ruta) {
		super(ruta);
	}

	protected void loadLevel(String ruta) {
		try {
			BufferedImage image = ImageIO.read(LoadedLevel.class.getResource(ruta));
			ancho = image.getWidth();
			alto = image.getHeight();
			tileList = new Tile[ancho * alto];
			pixels = new int[ancho * alto];

			image.getRGB(0, 0, ancho, alto, pixels, 0, ancho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void generateLevel() {
		for (int i = 0; i < pixels.length; i++) {

			switch (pixels[i]) {
			case 0xff090a09:
				tileList[i] = Tile.RoadUP;
				continue;
			case 0xff3b3b3b:
				tileList[i] = Tile.RoadLEFT;
				continue;
			case 0xff595959:
				tileList[i] = Tile.RoadCENTER;
				continue;
			case 0xff616161:
				tileList[i] = Tile.RoadRIGHT;
				continue;
			case 0xffd9b000:
				tileList[i] = Tile.Sand;
				continue;
			case 0xffbeb0ae:
				tileList[i] = Tile.SandTinyRock;
				continue;
			case 0xff837b79:
				tileList[i] = Tile.SandBigRock;
				continue;
			case 0xff288413:
				tileList[i] = Tile.SandCactus;
				continue;
			case 0xff72552c:
				tileList[i] = Tile.SandTinyBush;
				continue;
			case 0xff39b31e:
				tileList[i] = Tile.SandTinyCactus;
				continue;
			case 0xff31991a:
				tileList[i] = Tile.SandTinyCactusXINVERT;
				continue;
			case 0xff4f4417:
				tileList[i] = Tile.SandRoadUP;
				continue;
			case 0xff39310e:
				tileList[i] = Tile.SandRoadLEFT;
				continue;
			case 0xff30290c:
				tileList[i] = Tile.SandRoadRight;
				continue;
			case 0xff663e26:
				tileList[i] = Tile.SandRoofHouse1;
				continue;
			case 0xff7e4d2f:
				tileList[i] = Tile.SandRoofHouse2;
				continue;
			case 0xff6d4228:
				tileList[i] = Tile.SandRoofHouse3;
				continue;
			case 0xff5c3721:
				tileList[i] = Tile.SandRoofHouse4;
				continue;
			case 0xff75472b:
				tileList[i] = Tile.SandHouseLeftCorner;
				continue;
			case 0xff9c603b:
				tileList[i] = Tile.SandHouseWindows;
				continue;
			case 0xffaa6840:
				tileList[i] = Tile.SandHouseDoor;
				continue;
			case 0xff7e4b2d:
				tileList[i] = Tile.SandHouseRightCorner;
				continue;
			default:
				tileList[i] = Tile.Empty;

			}
		}
	}
}
