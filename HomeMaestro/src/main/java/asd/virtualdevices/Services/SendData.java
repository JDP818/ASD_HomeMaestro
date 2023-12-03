package asd.virtualdevices.Services;

import asd.homemaestro.mosquitto.MqttPublisher;
import asd.virtualdevices.Entities.Sensor;

public class SendData extends Thread{
    private Sensor sensor;
    private String sensorConnectionString;

    public SendData(Sensor sensor, String sensorConnectionString) {
        this.sensor = sensor;
        this.sensorConnectionString = sensorConnectionString;
    }

    public void run() {
        StartSendingData();
    }

    public void StartSendingData(){
        while (true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            MqttPublisher.publishMessage(sensorConnectionString, sensor.CreateReading());
        }
    }
}
