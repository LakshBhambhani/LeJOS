import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

//import lejos.nxt.Button;
//import lejos.nxt.LCD;
//import lejos.nxt.MotorPort;
//import lejos.nxt.NXTRegulatedMotor;
//import lejos.nxt.SensorPort;
//import lejos.nxt.Sound;
//import lejos.nxt.UltrasonicSensor;
//import lejos.util.Delay;

import lejos.hardware.Button;
import lejos.hardware.lcd.*;
import lejos.hardware.port.*;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.*;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

public class MappingSurroundings {
	public static void main(String[] args) {
		final int SPEED = 90;
		final float RATIO = (360f/(float)SPEED)*5.6722f;
		
		EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.C);
		EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		IRSensor sensor = new IRSensor(SensorPort.S4);
		
		ArrayList<String> data = new ArrayList<String>();
		
		FileOutputStream out = null;
		File file = new File("data.txt");
		
		Button.waitForAnyPress();
		
		leftMotor.setSpeed(SPEED);
		rightMotor.setSpeed(SPEED);
		
		leftMotor.rotate((int)(-SPEED*RATIO), true);
		rightMotor.rotate((int)(SPEED*RATIO), true);
		
		while(leftMotor.isMoving()||rightMotor.isMoving()){
			float distanceMark = sensor.getRange();			//.getDistance();
			
			if(String.valueOf(distanceMark).equals("Infinity"))
			{
				distanceMark = 70;
			}
			
			Delay.usDelay((long) (RATIO*10000));
			data.add(String.valueOf(distanceMark+13));	//Integer.toString(distanceMark+13)
			LCD.drawInt(data.size(), 0, 0);
		}
		
		try{
			out = new FileOutputStream(file);
		}catch(IOException e){
			System.err.println("Failed to create output stream");
			Button.waitForAnyPress();
			System.exit(1);
		}
		
		DataOutputStream dataOut = new DataOutputStream(out);
		
		try{
			for (int i = 0; i < data.size(); i++) {
				dataOut.writeChars(data.get(i)+",");
			}
			out.close();
		}catch(IOException e){
			System.err.println("Failed to write to output stream");
			Button.waitForAnyPress();
			System.exit(1);
		}
		
		Sound.buzz();
		
		Button.waitForAnyPress();
		
	}
}