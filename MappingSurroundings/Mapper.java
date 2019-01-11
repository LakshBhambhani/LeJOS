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

public class Mapper {
	private final int ANGLE = 10;

	public static void main(String args[]) throws UnsupportedEncodingException {
		new Mapper();
	}

	public Mapper() throws UnsupportedEncodingException{
		BufferedImage image = new BufferedImage(510, 510, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		
		String data = null;
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Plain text files", "txt");
		BufferedReader bIn = null;

		fileChooser.setFileFilter(filter);
		int returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == fileChooser.APPROVE_OPTION) {
			try {
				bIn = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			}
			
			try {
				data = bIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			float numberOfEntries = 0;
			ArrayList<String> distList = new ArrayList<String>();
			
			String entry = "";
			
			for(int i = 0; i < data.length()-1; i++){
				
				if(data.toCharArray()[i]==','){
					numberOfEntries+=1;
					distList.add(entry.trim());
					entry = "";
				}else{
					if (Character.isDigit(data.toCharArray()[i])) {
						entry+=Character.toString(data.toCharArray()[i]);
					}
				}
				
			}
			
			Point locations[] = new Point[(int)numberOfEntries];
			
			for (int i = 0; i < distList.size(); i++) {
				locations[i] = getLocation(Integer.parseInt(distList.get(i)), (360f/numberOfEntries)*(float)i);
			}
			
			for(int i = 0; i < locations.length-1; i++){
				g2d.drawLine((int)locations[i].getX(), (int)locations[i].getY(), (int)locations[i+1].getX(), (int)locations[i+1].getY());
				g2d.setColor(new Color(255, (int)Math.floor(((255f/(float)locations.length)*(float)i)), 255-(int)Math.floor(((255f/(float)locations.length)*(float)i))));
			}
			
			g2d.drawLine((int)locations[0].getX(), (int)locations[0].getY(), (int)locations[locations.length-1].getX(), (int)locations[locations.length-1].getY());
			
			g2d.setColor(Color.BLUE);
			g2d.fillRect(254, 254, 2, 2);
			
			File outputFile = new File(fileChooser.getSelectedFile().getParentFile() + "/image.png");
			System.out.println("Success");
			try {
				ImageIO.write(image, "png", outputFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
			
		} else {
			System.out.println("Something went wrong! Try Again!");
		}
	}

	public Point getLocation(int distance, float angle) {
		return new Point(
				(int) (distance * Math.cos(Math.toRadians(angle))) + 255,
				(int) (distance * Math.sin(Math.toRadians(angle))) + 255);
	}
}