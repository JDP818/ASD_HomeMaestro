package asd.virtualdevices.Services;

import asd.virtualdevices.Entities.Sensor;
import asd.homemaestro.mosquitto.MqttPublisher;
import asd.homemaestro.mosquitto.MqttSubscriber;
import asd.Utils.Consts;

public class SensorService extends Thread{
    private Sensor sensor;
    private String sensorConnectionString;

    private  MqttSubscriber mqttSubscriber;

    public SensorService(Sensor sensor) {
        this.sensor = sensor;
        this.mqttSubscriber = new MqttSubscriber();
    }

    public void run() {
        sensorConnectionString = Consts.GetSensorConnectionString(sensor.getId());
        StartDiscovery();
    }

    public void StartDiscovery(){
        mqttSubscriber.subscribeToTopic(
                sensorConnectionString,
                (topic, message) -> {
            String receivedMessage = new String(message.getPayload());
            SendData sendData = new SendData(sensor, sensorConnectionString);
            if(receivedMessage.equalsIgnoreCase(Consts.SENSORCONNECTIONTURNON)){
                sendData.start();
            }else if(receivedMessage.equalsIgnoreCase(Consts.SENSORCONNECTIONTURNOFF)){
                sendData.interrupt();
            }
        });
    }
}
