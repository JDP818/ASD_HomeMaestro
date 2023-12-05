package asd.virtualdevices;

import asd.virtualdevices.Entities.LightSensor;
import asd.virtualdevices.Entities.Sensor;
import asd.virtualdevices.Entities.TemperatureSensor;
import asd.virtualdevices.Services.SensorService;
import asd.virtualdevices.Services.Factories.SensorFactory;

import java.util.List;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        List<Sensor> sensors = SensorFactory.GetSensorList();

        Sensor TemperatureSensor1 = new TemperatureSensor("1");
        Sensor TemperatureSensor2 = new TemperatureSensor("2");
        Sensor LightSensor = new LightSensor("3");

        // Add the sensors to the list
        sensors.add(TemperatureSensor1);
        sensors.add(TemperatureSensor2);
        sensors.add(LightSensor);

        for (Sensor sensor : sensors) {
            if (sensor != null) {
                System.out.println("Creating service for sensor: " + sensor.getId());
                SensorService sensorService = new SensorService(sensor);
                sensorService.start();
            } else {
                System.out.println("Skipping null sensor.");
            }
        }

    }
}
