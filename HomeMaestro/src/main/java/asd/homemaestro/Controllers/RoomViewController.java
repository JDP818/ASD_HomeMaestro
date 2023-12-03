package asd.homemaestro.Controllers;

import asd.Utils.Consts;
import asd.homemaestro.Entities.Devices.Device;
import asd.homemaestro.Entities.Devices.DeviceCollection;
import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import asd.homemaestro.Entities.Rooms.Room;
import asd.homemaestro.mosquitto.MqttPublisher;
import asd.homemaestro.mosquitto.MqttSubscriber;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomViewController {

    @FXML
    private Pane sensorContainer;

    private Room Room;

    List<MqttSubscriber> mqttSubscriberList = new ArrayList<>();
    List<Label> labelList = new ArrayList<>();

    private int width = 50;
    private int height = 50;

    int[] x = { 25 };
    int[] y = { 25, 225, 425 };

    public  void setRoom(Room room){
        this.Room = room;
    }

    @FXML
    public void addDevices() {
        int i = 0;
        for (DeviceCollection deviceCollection: Room.getDeviceGroups()
        ) {
            for(Device device: deviceCollection.getDeviceList()){
                if(device instanceof Sensor){
                    Image image = new Image(Consts.GetSensorImage(device.getClass().getSimpleName()));
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(width);
                    imageView.setFitHeight(height);
                    Button imageButton = new Button();
                    imageButton.setGraphic(imageView);
                    imageButton.setLayoutX(25);
                    imageButton.setLayoutY(getY(i));
                    sensorContainer.getChildren().addAll(imageButton);
                    Label label = new Label();
                    label.setText(device.getName());
                    label.setLayoutX(110);
                    label.setLayoutY(getY(i));
                    label.setPrefWidth(width + 200);
                    label.setPrefHeight(height);
                    label.setAlignment(Pos.BASELINE_LEFT);
                    Font font = Font.font("Arial Black", 14);
                    label.setFont(font);
                    labelList.add(label);
                    sensorContainer.getChildren().addAll(label);
                    ToggleButton toggleButton = new ToggleButton("Off");
                    toggleButton.setLayoutX(40);
                    toggleButton.setLayoutY(getY(i)+75);
                    MqttSubscriber mqttSubscriber = new MqttSubscriber();
                    mqttSubscriberList.add(mqttSubscriber);
                    int finalI = i;
                    Label readingLabel = new Label("default");
                    readingLabel.setLayoutX(400);
                    readingLabel.setLayoutY(getY(i));
                    readingLabel.setPrefWidth(200);
                    readingLabel.setPrefHeight(height);
                    label.setAlignment(Pos.CENTER);
                    sensorContainer.getChildren().addAll(readingLabel);
                    toggleButton.setOnAction(event -> {
                        try {
                            updateToggleButton(toggleButton, device, readingLabel, finalI);
                        } catch (MqttException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    sensorContainer.getChildren().addAll(toggleButton);
                }
                i++;
            }
            sensorContainer.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        }
    }
    private int getY(int i){
        return y[i];
    }

    private void updateToggleButton(ToggleButton toggleButton, Device device, Label label, int i) throws MqttException {
        if (toggleButton.isSelected()) {
            toggleButton.setText("On");
            manageConnection(device, true, label, i);
        } else {
            toggleButton.setText("Off");
            manageConnection(device, false, label, i);
        }
    }

    private void manageConnection(Device device, Boolean on, Label label, int i) throws MqttException {
        MqttSubscriber mqttSubscriber = mqttSubscriberList.get(i);
        if(on){
            mqttSubscriber.subscribeToTopic(Consts.GetSensorConnectionString(device.getId()), (topic, message) -> {
                String receivedMessage = new String(message.getPayload());
                System.out.println("ReadingROOMCONTROLLER: " + receivedMessage);
                System.out.println("LABELTEXT: " + label.getText());
                System.out.println("DEVICE1ID: " + device.getId());
                Platform.runLater(() -> {
                    // Update the label text
                    label.setText(receivedMessage);
                });
            });
            MqttPublisher.publishMessage(
                    Consts.GetSensorConnectionString(device.getId()),
                    Consts.SENSORCONNECTIONTURNON);
        }else {
            MqttPublisher.publishMessage(
                    Consts.GetSensorConnectionString(device.getId()),
                    Consts.SENSORCONNECTIONTURNOFF);
            mqttSubscriber.unsubscribeFomTopic(Consts.GetSensorConnectionString(device.getId()));
        }
    }
}
