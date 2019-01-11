import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.SampleProvider;


public class IRSensor implements RangeFinder
{
	EV3IRSensor sensor;				// creates the sensor object
	SampleProvider sp;
    float[] sample, cms;
    float distance;
    	
    public IRSensor(Port port)		// constructor
	{
		sensor = new EV3IRSensor(port);
		sp = sensor.getDistanceMode();
	    	sample = new float[sp.sampleSize()];
	}

	public EV3IRSensor getSensor()
	{
		return sensor;
	}

	@Override
	public float getRange()			// get distance
	{
       		sp.fetchSample(sample, 0);
       		return sample[0];
	}
	
	public float[] getRanges()
	{
       		sp.fetchSample(sample, 0);

       		return sample;
	}
	
	public void close()
	{
		sensor.close();
	}
}