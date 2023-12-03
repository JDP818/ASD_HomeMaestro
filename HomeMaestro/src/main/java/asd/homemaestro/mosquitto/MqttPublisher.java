package asd.homemaestro.mosquitto;


import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.UUID;

public class MqttPublisher {
    private static String broker = "tcp://localhost:1883"; //MQTT Broker URL
    private static String clientId = UUID.randomUUID().toString(); //name of the client
    private static int qos = 0; //quality of service

    public static void publishMessage(String topic, String messageContext) {

        try {
            MqttClient client = new MqttClient(broker, clientId, new MemoryPersistence());
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            client.connect();

            client.isConnected();

            System.out.println("Publishing message: " + messageContext);
            MqttMessage mqttMessage = new MqttMessage(messageContext.getBytes());
            mqttMessage.setQos(qos);
            client.publish(topic, mqttMessage);

            System.out.println("Message published");

            client.disconnect();

        } catch (MqttException e) {
            e.printStackTrace();
        }

    }
}