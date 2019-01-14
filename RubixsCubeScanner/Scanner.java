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
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class Scanner {

	private static ColorSensor sensor = new ColorSensor(SensorPort.S3);
	FileOutputStream out = null;
	File file = new File("data.txt");

	private ArrayList<String> side1 = new ArrayList<String>();

	public static void main(String[] args) throws IOException {

		Scanner object = new Scanner();

		// side 1
		sensor.setColorIdMode();
		sensor.setFloodLight(false);

		for (int i = 0; i < 9; i++) {
	
			object.side1.add(ColorSensor.colorName(sensor.getColorID()));
			System.out.println("Scanning :" + object.side1.get(i).length() + " " + object.side1.get(i));
			System.out.println("Delay started");
			Delay.msDelay(2000);
		}

		try {
			object.out = new FileOutputStream(object.file);
		} catch (IOException e) {
			System.err.println("Failed to create output stream");
			Button.waitForAnyPress();
			System.exit(1);
		}

		DataOutputStream dataOut = new DataOutputStream(object.out);

		try {
			for (int i = 0; i < object.side1.size(); i++) {
				dataOut.writeChars(object.side1.get(i) + ",");
			}
			object.out.close();
		} catch (IOException e) {
			System.err.println("Failed to write to output stream");
			Button.waitForAnyPress();
			System.exit(1);
		}

//		// side 2
//		object.side2 = object.getSidesColors(object.side2);
//
//		// side 3
//		object.side3 = object.getSidesColors(object.side3);
//
//		// side 4
//		object.side4 = object.getSidesColors(object.side4);
//
//		// side 5
//		object.side5 = object.getSidesColors(object.side5);
//
//		// side 6
//		object.side6 = object.getSidesColors(object.side6);


	}

}
