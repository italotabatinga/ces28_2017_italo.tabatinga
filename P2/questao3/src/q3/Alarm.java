package q3;


public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private ISensor sensor;

    private boolean alarmOn;
    
    public Alarm(ISensor sensor) {
    	this.alarmOn = false;
    	this.sensor = sensor;
    }
    
    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            this.alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}