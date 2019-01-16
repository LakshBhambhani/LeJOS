import java.awt.Color;
import java.util.List;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class CubeMaker {

	private int[] side1X = { 1175, 1340, 1340, 1175, 1010, 1010, 1010, 1175, 1340 };
	private int[] side1Y = { 675, 675, 840, 840, 840, 675, 510, 510, 510 };

	private int[] side2X = { 1670, 1835, 1835, 1670, 1505, 1505, 1505, 1670, 1835 };
	private int[] side2Y = { 675, 675, 840, 840, 840, 675, 510, 510, 510 };

	private int[] side3X = { 185, 350, 350, 185, 20, 20, 20, 185, 350 };
	private int[] side3Y = { 675, 675, 840, 840, 840, 675, 510, 510, 510 };

	private int[] side4X = { 680, 845, 845, 680, 515, 515, 515, 680, 845 };
	private int[] side4Y = { 675, 675, 840, 840, 840, 675, 510, 510, 510 };

	private int[] side5X = { 680, 845, 845, 680, 515, 515, 515, 680, 845 };
	private int[] side5Y = { 180, 180, 345, 345, 345, 180, 15, 15, 15 };

	private int[] side6X = { 680, 845, 845, 680, 515, 515, 515, 680, 845 };
	private int[] side6Y = { 1175, 1175, 1340, 1340, 1340, 1175, 1010, 1010, 1010 };

	public static void main(String[] args) throws IOException {

		StringToColor stringToColor = new StringToColor();
		ColorDeterminer colorDeterminer = new ColorDeterminer();
		CubeMaker object = new CubeMaker();

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Cube.png"));
		} catch (IOException e) {

		}

		Graphics2D g2d = img.createGraphics();

		// side1
		String data = "";
		data = new String(Files.readAllBytes(Paths.get("side1.txt")));
		System.out.println(data);
		String[] side1 = data.split(",");

		// side2
		data = "";
		data = new String(Files.readAllBytes(Paths.get("side2.txt")));
		System.out.println(data);
		String[] side2 = data.split(",");

		// side3
		data = "";
		data = new String(Files.readAllBytes(Paths.get("side3.txt")));
		System.out.println(data);
		String[] side3 = data.split(",");

		// side4
		data = "";
		data = new String(Files.readAllBytes(Paths.get("side4.txt")));
		System.out.println(data);
		String[] side4 = data.split(",");

		// side5
		data = "";
		data = new String(Files.readAllBytes(Paths.get("side5.txt")));
		System.out.println(data);
		String[] side5 = data.split(",");

		// side6
		data = "";
		data = new String(Files.readAllBytes(Paths.get("side6.txt")));
		System.out.println(data);
		String[] side6 = data.split(",");

		File outputfile = new File("ModelledCube.png");
		String colour;

		// side1
		for (int i = 0; i < 9; i++) {
			String currentColor = side1[i];
			String colorInString = colorDeterminer.ColorDeterminer(currentColor);
			Color color = stringToColor.StringToColor(colorInString);
			System.out.println(color);
			g2d.setColor(color);
			g2d.fillRect(object.side1X[i], object.side1Y[i], 145, 145);
		}

		// side2
		for (int i = 0; i < 9; i++) {
			String currentColor = side2[i];
			String colorInString = colorDeterminer.ColorDeterminer(currentColor);
			Color color = stringToColor.StringToColor(colorInString);
			System.out.println(color);
			g2d.setColor(color);
			g2d.fillRect(object.side2X[i], object.side2Y[i], 145, 145);
		}

		// side3
		for (int i = 0; i < 9; i++) {
			String currentColor = side3[i];
			String colorInString = colorDeterminer.ColorDeterminer(currentColor);
			Color color = stringToColor.StringToColor(colorInString);
			System.out.println(color);
			g2d.setColor(color);
			g2d.fillRect(object.side3X[i], object.side3Y[i], 145, 145);
		}

		// side4
		for (int i = 0; i < 9; i++) {
			String currentColor = side4[i];
			String colorInString = colorDeterminer.ColorDeterminer(currentColor);
			Color color = stringToColor.StringToColor(colorInString);
			System.out.println(color);
			g2d.setColor(color);
			g2d.fillRect(object.side4X[i], object.side4Y[i], 145, 145);
		}

		// side5
		for (int i = 0; i < 9; i++) {
			String currentColor = side5[i];
			String colorInString = colorDeterminer.ColorDeterminer(currentColor);
			Color color = stringToColor.StringToColor(colorInString);
			System.out.println(color);
			g2d.setColor(color);
			g2d.fillRect(object.side5X[i], object.side5Y[i], 145, 145);
		}

		// side6
		for (int i = 0; i < 9; i++) {
			String currentColor = side6[i];
			String colorInString = colorDeterminer.ColorDeterminer(currentColor);
			Color color = stringToColor.StringToColor(colorInString);
			System.out.println(color);
			g2d.setColor(color);
			g2d.fillRect(object.side6X[i], object.side6Y[i], 145, 145);
		}

		ImageIO.write(img, "png", outputfile);
		System.out.println("Successfully made. Find your file in the same directory as this project.");

	}
}
