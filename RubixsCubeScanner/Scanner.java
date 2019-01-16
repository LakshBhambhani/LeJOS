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

/*
 * Docs: The code if you want to run only for one side
 * 
 * sensor.setColorIdMode();
//		sensor.setFloodLight(false);
//
//		for (int i = 0; i < 9; i++) {
//	
//			object.side1.add(ColorSensor.colorName(sensor.getColorID()));
//			System.out.println("Scanning :" + object.side1.get(i).length() + " " + object.side1.get(i));
//			System.out.println("Delay started");
//			Delay.msDelay(2000);
//		}
//
//		try {
//			object.out = new FileOutputStream(object.side1File);
//		} catch (IOException e) {
//			System.err.println("Failed to create output stream");
//			Button.waitForAnyPress();
//			System.exit(1);
//		}
//
//		DataOutputStream dataOut = new DataOutputStream(object.out);
//
//		try {
//			for (int i = 0; i < object.side1.size(); i++) {
//				dataOut.writeChars(object.side1.get(i) + ",");
//			}
//			object.out.close();
//		} catch (IOException e) {
//			System.err.println("Failed to write to output stream");
//			Button.waitForAnyPress();
//			System.exit(1);
//		}
 */

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class Scanner {

	private static ColorSensor sensor = new ColorSensor(SensorPort.S3);
	FileOutputStream out = null;
	
	File side1File = new File("side1.txt");
	File side2File = new File("side2.txt");
	File side3File = new File("side3.txt");
	File side4File = new File("side4.txt");
	File side5File = new File("side5.txt");
	File side6File = new File("side6.txt");

	private ArrayList<String> side1 = new ArrayList<String>();
	private ArrayList<String> side2 = new ArrayList<String>();
	private ArrayList<String> side3 = new ArrayList<String>();
	private ArrayList<String> side4 = new ArrayList<String>();
	private ArrayList<String> side5 = new ArrayList<String>();
	private ArrayList<String> side6 = new ArrayList<String>();

	public static void main(String[] args) throws IOException {

		Scanner object = new Scanner();

		// side 1
		object.scanToFile(object.side1, object.side1File);

		// side 2
		object.scanToFile(object.side2, object.side2File);

		// side 3
		object.scanToFile(object.side3, object.side3File);

		// side 4
		object.scanToFile(object.side4, object.side4File);

		// side 5
		object.scanToFile(object.side5, object.side5File);

		// side 6
		object.scanToFile(object.side6, object.side6File);


	}
	
	public void scanToFile(ArrayList<String> side, File file) {
		
		sensor.setColorIdMode();
		sensor.setFloodLight(false);

		for (int i = 0; i < 9; i++) {
	
			side.add(ColorSensor.colorName(sensor.getColorID()));
			System.out.println("Scanning" + side.get(i));
			System.out.println("Delay started");
			Delay.msDelay(2000);
		}

		try {
			out = new FileOutputStream(file);
		} catch (IOException e) {
			System.err.println("Failed to create output stream");
			Button.waitForAnyPress();
			System.exit(1);
		}

		DataOutputStream dataOut = new DataOutputStream(out);

		try {
			for (int i = 0; i < side.size(); i++) {
				dataOut.writeChars(side.get(i) + ",");
			}
			out.close();
		} catch (IOException e) {
			System.err.println("Failed to write to output stream");
			Button.waitForAnyPress();
			System.exit(1);
		}
	}

}

