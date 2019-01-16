
public class ColorDeterminer {

	public String ColorDeterminer(String data) {
		
		String color = " ";
		
		//  Blue
		if(data.contains("B") && data.contains("e")) {
	    	color = "Blue";
	    }
		
		// White
	    if(data.contains("W") && data.contains("e")) {
	    	color = "White";
	    }
	    
	    // Red
	    if(data.contains("R") && data.contains("d")) {
	    	color = "Red";
	    }
	    
	    // Yellow
	    if(data.contains("Y") && data.contains("w")) {
	    	color = "Yellow";
	    }
	    
	    // Green
	    if(data.contains("G") && data.contains("n")) {
	    	color = "Green";
	    }
	    
	    // Black
	    if(data.contains("B") && data.contains("k")) {
	    	color = "Black";
	    }
	    
	    return color;
	}
}
