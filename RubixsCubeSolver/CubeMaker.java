import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Box.Filler;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * Docs: 
 * 
 * 
 * 
 * sides: 1010, 1175, 1340, 1505, 1670, 1835
 */

public class CubeMaker {

	private static Color color;
	private StringToColor stringToColor = new StringToColor();

	private int[] side1X = {};
	private int[] side1Y = {};

	private int[] side2X = {};
	private int[] side2Y = {};

	private int[] side3X = {};
	private int[] side3Y = {};

	private int[] side4X = {};
	private int[] side4Y = {};

	private int[] side5X = {};
	private int[] side5Y = {};

	private int[] side6X = {};
	private int[] side6Y = {};

	public CubeMaker(String[] side1, String[] side2, String[] side3, String[] side4, String[] side5, String[] side6)
			throws IOException {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Cube.png"));
		} catch (IOException e) {
		}
		Graphics2D g2d = img.createGraphics();

		// side1
		for (int i = 0; i < 9; i++) {
			String colour = side1[i];
			color = stringToColor.StringToColor(colour);
			g2d.setColor(color);
			g2d.fillRect(side1X[i], side1Y[i], 145, 145);
		}

		// side2
		for (int i = 0; i < 9; i++) {
			String colour = side2[i];
			color = stringToColor.StringToColor(colour);
			g2d.setColor(color);
			g2d.fillRect(side2X[i], side2Y[i], 145, 145);
		}

		// side3
		for (int i = 0; i < 9; i++) {
			String colour = side3[i];
			color = stringToColor.StringToColor(colour);
			g2d.setColor(color);
			g2d.fillRect(side3X[i], side3Y[i], 145, 145);
		}

		// side4
		for (int i = 0; i < 9; i++) {
			String colour = side4[i];
			color = stringToColor.StringToColor(colour);
			g2d.setColor(color);
			g2d.fillRect(side4X[i], side4Y[i], 145, 145);
		}

		// side5
		for (int i = 0; i < 9; i++) {
			String colour = side5[i];
			color = stringToColor.StringToColor(colour);
			g2d.setColor(color);
			g2d.fillRect(side5X[i], side5Y[i], 145, 145);
		}

		// side6
		for (int i = 0; i < 9; i++) {
			String colour = side6[i];
			color = stringToColor.StringToColor(colour);
			g2d.setColor(color);
			g2d.fillRect(side6X[i], side6Y[i], 145, 145);
		}

		g2d.setColor(Color.RED);
		g2d.fillRect(1835, 520, 145, 145);
		File outputfile = new File("saved.png");
		ImageIO.write(img, "png", outputfile);
		System.out.println("Successfull");

	}

	public static void main(String[] args) throws IOException {
		// CubeMaker object2 = new CubeMaker();

	}
}
