import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;
import lejos.hardware.ev3.*;
import lejos.robotics.SampleProvider;

public class IRSensorDemo {

	public static void main(String[] args)
    {
        float range;
        IRSensor sensor = new IRSensor(SensorPort.S4);
        
        System.out.println("UltraSonic Demo");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);    // flash green led and
        Sound.beepSequenceUp();    // make sound when ready.

        Button.waitForAnyPress();
        
        range = sensor.getRange();

        while(true)
        {
        	Lcd.clear(7, 7, 10);
            Lcd.print(7, 7, "%.3f", range);
            Delay.msDelay(500);
            range = sensor.getRange();
            
            if(Button.ENTER.isDown())
            {
            	System.exit(0);
            }
        }
        
        
       
    }
}
