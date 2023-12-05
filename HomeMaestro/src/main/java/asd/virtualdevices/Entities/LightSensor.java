package asd.virtualdevices.Entities;

import asd.Utils.Consts;
import asd.Utils.SensorType;

import java.util.Random;

public class LightSensor extends Sensor {

    public LightSensor() {
        super();
    }

    public LightSensor(String Id) {
        super(Id);
    }

    @Override
    public String CreateReading() {
        int minRange = 0;  // Night
        int maxRange = 2;  // Intermediary light
        Random random = new Random();
        int randomInRange = random.nextInt(maxRange - minRange + 1) + minRange;
        SensorReading sensorReading = new SensorReading(randomInRange);
        return sensorReading.toString();
    }

    @Override
    public String toString() {
        return super.getId() + "," + SensorType.Light;
    }
}
