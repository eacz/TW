package level.tile;

import graphics.Screen;
import graphics.Sprite;

public class Tile {
	public int x;
	public int y;
	public Sprite sprite;

	// Tile collection
	public static final Tile Empty = new Tile(Sprite.Empty);
	public static final Tile RoadUP = new Tile(Sprite.RoadUP);
	public static final Tile RoadLEFT = new Tile(Sprite.RoadLEFT);
	public static final Tile RoadRIGHT = new Tile(Sprite.RoadRIGHT);
	public static final Tile RoadCENTER = new Tile(Sprite.RoadCENTER);

	// desert
	public static final Tile Sand = new Tile(Sprite.Sand);
	public static final Tile SandTinyRock = new Tile(Sprite.SandTinyRock);
	public static final Tile SandBigRock = new Tile(Sprite.SandBigRock);
	public static final Tile SandCactus = new Tile(Sprite.SandCactus);
	public static final Tile SandTinyBush = new Tile(Sprite.SandTinyBush);
	public static final Tile SandTinyCactus = new Tile(Sprite.SandTinyCactus);
	public static final Tile SandTinyCactusXINVERT = new Tile(Sprite.SandTinyCactusINVERTX);
	public static final Tile SandRoadUP = new Tile(Sprite.SandRoadUP);
	public static final Tile SandRoadLEFT = new Tile(Sprite.SandRoadLEFT);
	public static final Tile SandRoadRight = new Tile(Sprite.SandRoadRIGHT);
	// house
	public static final Tile SandRoofHouse1 = new Tile(Sprite.SandRoofHouse1);
	public static final Tile SandRoofHouse2 = new Tile(Sprite.SandRoofHouse2);
	public static final Tile SandRoofHouse3 = new Tile(Sprite.SandRoofHouse3);
	public static final Tile SandRoofHouse4 = new Tile(Sprite.SandRoofHouse4);
	public static final Tile SandHouseLeftCorner = new Tile(Sprite.SandHouseLeftCorner);
	public static final Tile SandHouseWindows = new Tile(Sprite.SandHouseWindows);
	public static final Tile SandHouseDoor = new Tile(Sprite.SandHouseDoor);
	public static final Tile SandHouseRightCorner = new Tile(Sprite.SandHouseRightCorner);
	// house
	// desert

	//

	public Tile(Sprite sprite) {
		this.sprite = sprite;

	}

	public void show(int x, int y, Screen screen) {
		screen.showTile(x << 5, y << 5, this);
	}

	public boolean solid() {

		return false;
	}
}
