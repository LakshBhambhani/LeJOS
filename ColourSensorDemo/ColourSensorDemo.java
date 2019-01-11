import lejos.hardware.*;
import lejos.hardware.port.*;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class ColourSensorDemo {

	public static void main(String[] args)
	{
		ColorSensor sensor = new ColorSensor(SensorPort.S3);
		SampleProvider sp;
		
		System.out.println("Colour Sensor Demo");
		System.out.println("Press any key to continue");
		
		Button.LEDPattern(4);
		Sound.beepSequenceUp();
		
		Button.waitForAnyPress();
		
		sensor.setColorIdMode();
        sensor.setFloodLight(false);
		
		while(true)
		{ 
	        Lcd.clear(7);
            Lcd.print(7, "id=%s", ColorSensor.colorName(sensor.getColorID()));
            Delay.msDelay(250);
            
            if(Button.ENTER.isDown())
            {
            	System.exit(0);
            }
            	
		}
	}
}
