import lejos.hardware.*;
import lejos.hardware.port.*;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class TouchSensorDemo {

	public static void main(String[] args)
	{
		TouchSensor sensor = new TouchSensor(SensorPort.S1);
		SampleProvider sp;
		boolean touched;
		String message;
		
		System.out.println("Touch Sensor Demo");
		System.out.println("Press any key to get started");
		
		Button.LEDPattern(4);    // flash green led and
        Sound.beepSequenceUp();  // make sound when ready.
        
        Button.waitForAnyPress();
        
        touched = sensor.isTouched();
        
        while(true)
        {
        	Lcd.clear(7, 0, 10);
        	message = String.valueOf(touched);
            Lcd.print(7, message);
            Delay.msDelay(500);
            touched = sensor.isTouched();
        	
        	if(Button.ENTER.isDown())
        	{
        		System.exit(0);
        	}
        }
	}
}
