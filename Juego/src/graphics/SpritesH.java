package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpritesH {
	private final int ancho;
	private final int alto;
	public final int[] pixels;

	// sprites sheets colection
	public static SpritesH p1 = new SpritesH("/text/escenarios1.png", 320, 320);
	public static SpritesH p2 = new SpritesH("/psjs/psjes1.png", 320, 320);
	public static SpritesH playerSheet = new SpritesH("/psjs/player.png", 320, 320);
	// end

	public SpritesH(final String ruta, final int ancho, final int alto) {
		this.alto = alto;
		this.ancho = ancho;

		pixels = new int[ancho * alto];

		BufferedImage img;
		try {
			img = ImageIO.read(SpritesH.class.getResource(ruta));

			img.getRGB(0, 0, ancho, alto, pixels, 0, ancho);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getAncho() {
		return ancho;
	}
}
