package asd.virtualdevices.Entities;

import asd.Utils.Consts;
import asd.Utils.SensorType;

import java.util.List;
import java.util.Random;

public class TemperatureSensor extends Sensor{
    private int minRange = 20;
    private int maxRange = 24;
    private int index = 0;
    private int customValueIndex = 1;
    private int cooldown = 60;
    private int[] customValues = {28, 14};

    public TemperatureSensor() {
        super();
    }

    public TemperatureSensor(String Id) {
        super(Id);
    }

    @Override
    public String CreateReading() {
        Random random = new Random();
        int randomInRange = random.nextInt(maxRange - minRange + 1) + minRange;
        SensorReading sensorReading = new SensorReading(randomInRange);
        if(index == cooldown
            && customValueIndex <= customValues.length){
            sensorReading = new SensorReading(customValues[customValueIndex-1]);
            customValueIndex++;
            index = 0;
        }
        index++;
        return sensorReading.toString();
    }

    @Override
    public String toString(){
        return super.getId() + "," + SensorType.Temperature;
    }
}
