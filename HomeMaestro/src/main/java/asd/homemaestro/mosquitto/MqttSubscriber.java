package asd.homemaestro.mosquitto;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.lang.Thread.sleep;

public class MqttSubscriber {
    private static String broker = "tcp://localhost:1883"; //MQTT Broker URL
    private String clientId; //name of the client
    private static int qos = 0; //quality of service
    private MqttAsyncClient clientInUse;

    public MqttSubscriber(){
        this.clientId = UUID.randomUUID().toString();
    }

    public void subscribeToTopic(String topic, IMqttMessageListener listener) {
        try {
            MqttAsyncClient client = new MqttAsyncClient(broker, clientId, new MemoryPersistence());
            clientInUse = client;
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to client: " + clientId);
            IMqttToken connectToken = client.connect(connOpts);
            connectToken.waitForCompletion();
            client.subscribe(topic, qos).waitForCompletion();
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Connection lost");
                }

                @Override
                public void messageArrived(String receivedTopic, MqttMessage message) throws Exception {
                    if (topic.equals(receivedTopic)) {
                        listener.messageArrived(receivedTopic, message);
                    }
                }
                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void unsubscribeFomTopic(String topic) throws MqttException {
            clientInUse.unsubscribe(topic);
            clientInUse.disconnect();
    }
}