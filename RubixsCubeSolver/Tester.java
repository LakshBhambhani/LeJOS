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
import java.util.Arrays;

public class Tester {
	
	private static Color color;
	private static StringToColor object = new StringToColor();

	public static void main(String[] args) {
		
//		BufferedImage img = null;
//		try {
//		    img = ImageIO.read(new File("Cube.png"));
//		} catch (IOException e) {
//		}
//		Graphics2D g2d = img.createGraphics();
//		
//		String colour = "red";
//		color = String.valueOf(colour);
//		g2d.setColor(color);
		
		String color = "Black";
		Color[] colour = new Color[2];
		colour[0] = object.StringToColor(color);
		
		System.out.println(Arrays.toString(colour));
	}
}
