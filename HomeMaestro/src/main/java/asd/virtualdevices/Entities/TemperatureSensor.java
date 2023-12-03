package asd.virtualdevices.Entities;

import asd.Utils.Consts;
import asd.Utils.SensorType;

import java.util.Random;

public class TemperatureSensor extends Sensor{

    public TemperatureSensor() {
        super();
    }

    public TemperatureSensor(String Id) {
        super(Id);
    }

    @Override
    public String CreateReading() {
        int minRange = 22;
        int maxRange = 24;
        Random random = new Random();
        int randomInRange = random.nextInt(maxRange - minRange + 1) + minRange;
        SensorReading sensorReading = new SensorReading(randomInRange);
        return sensorReading.toString();
    }

    @Override
    public String toString(){
        return super.getId() + "," + SensorType.Temperature;
    }
}
