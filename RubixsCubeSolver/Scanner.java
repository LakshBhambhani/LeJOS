/*
 * Name: Laksh Bhambhani
 * Description:
 * Notes: 
 * 		int width = 300;
		int height = 300;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = img.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.BLACK);
		graphics.fillOval(0,0, width, height);
		graphics.dispose();
		File file = new File("Image.png");
		ImageIO.write(img, "png", file);
 */

import java.awt.color.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import javax.imageio.ImageIO;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class Scanner {

	ColorSensor sensor = new ColorSensor(SensorPort.S3);
	
	private String[] side1 = new String[9];
	private String[] side2 = new String[9];
	private String[] side3 = new String[9];
	private String[] side4 = new String[9];
	private String[] side5 = new String[9];
	private String[] side6 = new String[9];

	public static void main(String[] args) throws IOException {

		
		Scanner object = new Scanner();
		

		// side 1
		object.side1 = object.getSidesColors(object.side1);
		
		// side 2
		object.side2 = object.getSidesColors(object.side2);

		// side 3
		object.side3 = object.getSidesColors(object.side3);

		// side 4
		object.side4 = object.getSidesColors(object.side4);

		// side 5
		object.side5 = object.getSidesColors(object.side5);

		// side 6
		object.side6 = object.getSidesColors(object.side6);
		
		CubeMaker object2 = new CubeMaker(object.side1, object.side2, object.side3, object.side4, object.side5, object.side6);
		
	}
	
	public String[] getSidesColors(String[] side) {
		
		sensor.setColorIdMode();
		sensor.setFloodLight(false);
		
		for(int i = 0; i < 9; i++) {
			side[i] = ColorSensor.colorName(sensor.getColorID());
			Delay.msDelay(1000);
		}
		
		return side;
	}
}