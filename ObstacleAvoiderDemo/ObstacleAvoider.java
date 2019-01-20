import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RangeFinderAdapter;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.FeatureListener;
import lejos.robotics.objectdetection.RangeFeatureDetector;
 
 
public class ObstacleAvoider {
     
    static final float MAX_DISTANCE = 50f;
    static final int DETECTOR_DELAY = 1000;
 
	public static void main(String[] args) {    
        //final DifferentialPilot robot = new DifferentialPilot(4.0,18.0,Motor.B, Motor.C);
        final MovePilot robot = new MovePilot(4.0, 18.0, Motor.C, Motor.A);
        EV3IRSensor ir = new EV3IRSensor(SensorPort.S4);
        RangeFeatureDetector detector = new RangeFeatureDetector(new RangeFinderAdapter(ir.getDistanceMode()), MAX_DISTANCE, DETECTOR_DELAY);
 
        detector.enableDetection(true);
        robot.forward();
         
        detector.addListener(new FeatureListener() {
			public void featureDetected(Feature feature, FeatureDetector detector) {
                detector.enableDetection(false);
                robot.travel(-30);
                robot.rotate(90);
                detector.enableDetection(true);
                robot.forward();
            }       
        });
         
        while(Button.ESCAPE.isUp()) Thread.yield();
    }
}