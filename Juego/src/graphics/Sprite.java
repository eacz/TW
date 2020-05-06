package graphics;

public final class Sprite {
	private final int size;
	private int x;
	private int y;
	public int[] pixels;
	private SpritesH hoja;

	// sprites collection
	// scenaries

	// SPRITESH1
	// desert

	public static final Sprite Sand = new Sprite(32, 4, 0, SpritesH.p1, 0);
	public static final Sprite SandTinyRock = new Sprite(32, 5, 0, SpritesH.p1, 0);
	public static final Sprite SandBigRock = new Sprite(32, 6, 0, SpritesH.p1, 0);
	public static final Sprite SandCactus = new Sprite(32, 7, 0, SpritesH.p1, 0);
	public static final Sprite SandTinyBush = new Sprite(32, 8, 0, SpritesH.p1, 0);
	public static final Sprite SandTinyCactus = new Sprite(32, 9, 0, SpritesH.p1, 0);
	public static final Sprite SandTinyCactusINVERTX = new Sprite(32, 9, 0, SpritesH.p1, 1);
	public static final Sprite SandRoadUP = new Sprite(32, 0, 1, SpritesH.p1, 0);
	public static final Sprite SandRoadLEFT = new Sprite(32, 1, 1, SpritesH.p1, 0);
	public static final Sprite SandRoadRIGHT = new Sprite(32, 1, 1, SpritesH.p1, 7);
	// house
	public static final Sprite SandRoofHouse1 = new Sprite(32, 1, 2, SpritesH.p1, 0);
	public static final Sprite SandRoofHouse2 = new Sprite(32, 1, 3, SpritesH.p1, 0);
	public static final Sprite SandRoofHouse3 = new Sprite(32, 1, 4, SpritesH.p1, 0);
	public static final Sprite SandRoofHouse4 = new Sprite(32, 1, 5, SpritesH.p1, 0);
	public static final Sprite SandHouseLeftCorner = new Sprite(32, 1, 6, SpritesH.p1, 0);
	public static final Sprite SandHouseWindows = new Sprite(32, 1, 7, SpritesH.p1, 0);
	public static final Sprite SandHouseDoor = new Sprite(32, 1, 8, SpritesH.p1, 0);
	public static final Sprite SandHouseRightCorner = new Sprite(32, 1, 9, SpritesH.p1, 0);
	// house
	// desert

	// road
	public static final Sprite RoadUP = new Sprite(32, 0, 0, SpritesH.p1, 0);
	public static final Sprite RoadLEFT = new Sprite(32, 1, 0, SpritesH.p1, 0);
	public static final Sprite RoadCENTER = new Sprite(32, 2, 0, SpritesH.p1, 0);
	public static final Sprite RoadRIGHT = new Sprite(32, 3, 0, SpritesH.p1, 0);
	// road
	// SPRITESH1/

	// Start Player
	public static final Sprite Front0 = new Sprite(32, 0, 0, SpritesH.playerSheet, 0);
	public static final Sprite Front1 = new Sprite(32, 0, 1, SpritesH.playerSheet, 0);
	public static final Sprite Front2 = new Sprite(32, 0, 2, SpritesH.playerSheet, 0);

	public static final Sprite Back0 = new Sprite(32, 1, 0, SpritesH.playerSheet, 0);
	public static final Sprite Back1 = new Sprite(32, 1, 1, SpritesH.playerSheet, 0);
	public static final Sprite Back2 = new Sprite(32, 1, 2, SpritesH.playerSheet, 0);

	public static final Sprite Right0 = new Sprite(32, 2, 0, SpritesH.playerSheet, 0);
	public static final Sprite Right1 = new Sprite(32, 2, 1, SpritesH.playerSheet, 0);
	public static final Sprite Right2 = new Sprite(32, 2, 2, SpritesH.playerSheet, 0);

	public static final Sprite Left0 = new Sprite(32, 3, 0, SpritesH.playerSheet, 0);
	public static final Sprite Left1 = new Sprite(32, 3, 1, SpritesH.playerSheet, 0);
	public static final Sprite Left2 = new Sprite(32, 3, 2, SpritesH.playerSheet, 0);
	// End Player

	// Character
	public static Sprite blas = new Sprite(32, 0, 0, SpritesH.p2, 0);

	//
	public static final Sprite Empty = new Sprite(32, 0);
	// end

	public Sprite(final int size, final int fila, final int columna, final SpritesH hoja, final int version) {
		this.size = size;
		pixels = new int[size * size];
		this.x = size * fila;
		this.y = size * columna;
		this.hoja = hoja;
		LoadSprite(version);
	}

	public Sprite(final int size, final int color) {
		this.size = size;
		pixels = new int[size * size];

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}

	public int getLado() {
		return size;
	}

	private void LoadSprite(int version) {
		if (version == 0) {
			normalLoad();
		} else {
			manipulateLoad(version);
		}
	}

	private void normalLoad() {
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				pixels[x + y * size] = hoja.pixels[(x + this.x) + (y + this.y) * hoja.getAncho()];
			}
		}
	}

	private void manipulateLoad(int version) {
		int[] temporalPixels = startTemporalPixels();

		switch (version) {
		case 1:
			invertX(temporalPixels);
			break;
		case 2:
			invertY(temporalPixels);
			break;
		case 3:
			invertXY(temporalPixels);
			break;
		case 4:
			rotate90Left(temporalPixels);
			break;
		case 5:
			rotate90Right(temporalPixels);
			break;
		case 6:
			rotate80Left_YInvert(temporalPixels);
			break;
		case 7:
			rotate90Right_YInvert(temporalPixels);
			break;
		default:
			normalLoad();

		}
	}

	private int[] startTemporalPixels() {
		int[] temporalPixels = new int[size * size];
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				temporalPixels[x + y * size] = hoja.pixels[(x + this.x) + (y + this.y) * hoja.getAncho()];
			}
		}
		return temporalPixels;
	}

	// Rotate Methods

	// case1
	private void invertX(int[] temporalPixels) {
		int i = 0;
		for (int y = 0; y < size; y++) {
			for (int x = size - 1; x > -1; x--) {
				pixels[i] = temporalPixels[x + y * size];
				i++;
			}
		}
	}

	// case2
	private void invertY(int[] temporalPixels) {
		int i = 0;
		for (int y = size - 1; y > -1; y--) {
			for (int x = 0; x < size; x++) {
				pixels[i] = temporalPixels[x + y * size];
				i++;
			}
		}

	}

	// case3
	private void invertXY(int[] temporalPixels) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = temporalPixels[temporalPixels.length - 1 - i];
		}
	}

	// case4
	private void rotate90Left(int[] temporalPixels) {
		int i = 0;
		for (int x = size - 1; x > -1; x--) {
			for (int y = 0; y < size; y++) {
				pixels[i] = temporalPixels[x + y * size];
				i++;
			}
		}
	}

	// case5
	private void rotate90Right(int[] temporalPixels) {
		int i = 0;
		for (int x = 0; x < size; x++) {
			for (int y = size - 1; y > -1; y--) {
				pixels[i] = temporalPixels[x + y * size];
				i++;
			}
		}
	}

	// case6
	private void rotate80Left_YInvert(int[] temporalPixels) {
		int i = 0;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				pixels[i] = temporalPixels[x + y * size];
				i++;
			}
		}
	}

	// case7
	private void rotate90Right_YInvert(int[] temporalPixels) {
		int i = 0;
		for (int x = size - 1; x > -1; x--) {
			for (int y = size - 1; y > -1; y--) {
				pixels[i] = temporalPixels[x + y * size];
				i++;
			}
		}
	}

}
