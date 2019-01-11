import java.awt.Color;

public class StringToColor {

	private Color colorToSet;
	
	public Color StringToColor(String colorRecieved) {
		
		if(colorRecieved.equals("Black")) {
			colorToSet = Color.BLACK;
		}
		else if(colorRecieved.equals("Blue")) {
			colorToSet = Color.BLUE;
		}
		else if(colorRecieved.equals("Cyan")) {
			colorToSet = Color.CYAN;
		}
		else if(colorRecieved.equals("Dark Gray")) {
			colorToSet = Color.DARK_GRAY;
		}
		else if(colorRecieved.equals("Gray")) {
			colorToSet = Color.GRAY;
		}
		else if(colorRecieved.equals("Green")) {
			colorToSet = Color.GREEN;
		}
		else if(colorRecieved.equals("Light Gray")) {
			colorToSet = Color.LIGHT_GRAY;
		}
		else if(colorRecieved.equals("Magenta")) {
			colorToSet = Color.MAGENTA;
		}
		else if(colorRecieved.equals("Orange")) {
			colorToSet = Color.ORANGE;
		}
		else if(colorRecieved.equals("Pink")) {
			colorToSet = Color.PINK;
		}
		else if(colorRecieved.equals("Red")) {
			colorToSet = Color.RED;
		}
		else if(colorRecieved.equals("White")) {
			colorToSet = Color.WHITE;
		}
		else if(colorRecieved.equals("Yellow")) {
			colorToSet = Color.YELLOW;
		}
		
		return colorToSet;
	}
}
