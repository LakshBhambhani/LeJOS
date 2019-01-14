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

	private int[] side1X = {185, 350, 350, 185, 20, 20, 20, 185, 350};
	private int[] side1Y = {675, 675, 840, 840, 840, 675, 510, 510, 510};

	private int[] side2X = {680, 845, 845, 680, 515, 515, 515, 680, 845};
	private int[] side2Y = {675, 675, 840, 840, 840, 675, 510, 510, 510};

	private int[] side3X = {1175, 1340, 1340, 1175, 1010, 1010, 1010, 1175, 1340};
	private int[] side3Y = {675, 675, 840, 840, 840, 675, 510, 510, 510};

	private int[] side4X = {1670, 1835, 1835, 1670, 1505, 1505, 1505, 1670, 1835};
	private int[] side4Y = {675, 675, 840, 840, 840, 675, 510, 510, 510};

	private int[] side5X = {680, 845, 845, 680, 515, 515, 515, 680, 845};
	private int[] side5Y = {180, 180, 345, 345, 345, 180, 15, 15, 15};

	private int[] side6X = {680, 845, 845, 680, 515, 515, 515, 680, 845};
	private int[] side6Y = {1175, 1175, 1340, 1340, 1340, 1175, 1010, 1010, 1010};

	public static void main(String[] args) throws IOException {
		
		StringToColor stringToColor = new StringToColor();
		StringToInt StringToInt = new StringToInt();
		CubeMaker object = new CubeMaker();
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Cube.png"));
		} catch (IOException e) {
		}
		
		Graphics2D g2d = img.createGraphics();

		List<String> lines = Collections.emptyList(); 
		
		
		try {lines = Files.readAllLines(Paths.get("data.txt"), StandardCharsets.UTF_8); } 
		catch (IOException e) {  
			e.printStackTrace(); } 
		
		List<String> result = new ArrayList<>();
		
		try (FileReader f = new FileReader("data.txt")) {
		    StringBuffer sb = new StringBuffer();
		    while (f.ready()) {
		        char c = (char) f.read();
		        if (c == ',') {
		            result.add(sb.toString());
		            sb = new StringBuffer();
		        } else {
		            sb.append(c);
		        }
		    }
		    if (sb.length() > 0) {
		        result.add(sb.toString());
		    }
		}       
		System.out.println("Result:");
		System.out.println(result);
		System.out.println("Size: " + result.size());
		
		File outputfile = new File("ModelledCube.png");
		String colour;
		
		for (int i = 0; i < 9; i++) {
			
			colour = result.get(i).toString();
			System.out.println(colour);
			Color color = stringToColor.StringToColor(colour); 
			System.out.println(color);
			g2d.setColor(color);
			g2d.fillRect(object.side1X[i], object.side1Y[i], 145, 145);
			
		}
	
		ImageIO.write(img, "png", outputfile);
		System.out.println("Successfully made. Find your file in the same directory as this project.");

		
	}
}
