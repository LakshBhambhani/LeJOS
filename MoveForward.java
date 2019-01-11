import lejos.hardware.*;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.*;

public class MoveForward {

	public static void main(String[] args) {
		
		System.out.println("Drive forward and stop");
		System.out.println("Press any key to start");
		
		Button.LEDPattern(4);
		Button.waitForAnyPress();
		
		UnregulatedMotor leftMotor = new UnregulatedMotor(MotorPort.B);
		UnregulatedMotor rightMotor = new UnregulatedMotor(MotorPort.C);
		UnregulatedMotor handMotor = new UnregulatedMotor(MotorPort.A);
		
		leftMotor.setPower(50);
		rightMotor.setPower(50);
		handMotor.setPower(80);
		
		Delay.msDelay(2000);
		
		leftMotor.stop();
		rightMotor.stop();
		handMotor.stop();
		
		leftMotor.close();
		rightMotor.close();
		handMotor.close();
		
		Button.LEDPattern(4);
	}
}
