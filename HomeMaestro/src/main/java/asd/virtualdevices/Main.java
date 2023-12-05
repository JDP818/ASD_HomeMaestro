package asd.virtualdevices;

import asd.virtualdevices.Entities.Sensor;
import asd.virtualdevices.Services.SensorService;
import asd.virtualdevices.Services.Factories.SensorFactory;

import java.util.List;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        List<Sensor> sensors = SensorFactory.GetSensorList();
        for(Sensor sensor: sensors){
            SensorService sensorService = new SensorService(sensor);
            sensorService.start();
        }
    }
}
