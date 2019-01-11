import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.SampleProvider;


public class UltrasonicSensor implements RangeFinder
{
	EV3UltrasonicSensor sensor;
	SampleProvider sp;
    float[] sample, cms;
    float distance;
    private double[] valuesRecieved = {-16.640, -16.638, -16.636, -16.634, -16.632, -16.630, -16.628, -16.626, 
			-16.624, -16.622, -16.620, -16.618, -16.616, -16.614, -16.612, -16.610, -16.608, -16.606, -16.604, 
			-16.602, -16.600, -16.598, -16.596, -16.594, -16.592, -16.590, -16.588, -16.586, -16.584, -16.582, 
			-16.580, -16.578, -16.576, -16.574, -16.572, -16.570, -16.568, -16.566, -16.564, -16.562, -16.560, 
			-16.558, -16.556, -16.554, -16.552, -16.550, -16.548, -16.546, -16.544, -16.542, -16.540};
	
	private float[] rangeValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 
			24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
			50};

    /**
     * Creates UltraSonicSensor object. This is a wrapper class for EV3UltrasonicSensor.
     * @param port SensorPort of EV3UltrasonicSensor device.
     */
	public UltrasonicSensor(Port port)
	{
		sensor = new EV3UltrasonicSensor(port);
		sp = sensor.getDistanceMode();
	    	sample = new float[sp.sampleSize()];
	}

	/**
	 * Returns the underlying EV3UltrasonicSensor object.
	 * @return Sensor object reference.
	 */
	public EV3UltrasonicSensor getSensor()
	{
		return sensor;
	}

	/**
	 * Get range (distance) to object detected by UltraSonic sensor.
	 * @return Distance in centimeters.
	 */
	@Override
	public float getRange()
	{
       		sp.fetchSample(sample, 0);
       		return sample[0];
//       		for(int i = 0; i < valuesRecieved.length; i++)
//       		{
//       			if(sample[0] == valuesRecieved[i])
//       			{
//       				distance = rangeValues[i];
//       			}
//       		}
//       		return distance;
	}

	/**
	 * Get range (distance) to object detected by UltraSonic sensor.
	 * @return Distance in meters. Only one distance value is returned.
	 */
	@Override
	public float[] getRanges()
	{
       		sp.fetchSample(sample, 0);

       		return sample;
	}
	
	/**
	 * Determine if UltraSonic sensor is enabled.
	 * @return True if enabled, false if not.
	 */
	public boolean isEnabled()
	{
		return sensor.isEnabled();
	}
	
	/**
	 * Enable UltraSonic sensor.
	 */
	public void enable()
	{
		sensor.enable();
	}
	
	/**
	 * Disable UltraSonic sensor.
	 */
	public void disable()
	{
		sensor.disable();
	}
	
	/**
	 * Release resources.
	 */
	public void close()
	{
		sensor.close();
	}
}
