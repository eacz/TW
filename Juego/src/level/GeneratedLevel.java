package level;

import java.util.Random;

public class GeneratedLevel extends Level {

	private static final Random random = new Random();

	public GeneratedLevel(int ancho, int alto) {
		super(ancho, alto);
	}

	protected void generateLevel() {
		for (int y = 0; y < alto; y++) {
			for (int x = 0; x < ancho; x++) {
				tiles[x + y * ancho] = random.nextInt(4) + 4;
			}
		}
	}
}
