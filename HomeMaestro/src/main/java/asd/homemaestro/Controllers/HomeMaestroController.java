package asd.homemaestro.Controllers;

import asd.Utils.ActuatorType;
import asd.Utils.Consts;
import asd.homemaestro.Entities.Devices.Actuators.Actuator;
import asd.homemaestro.Entities.Devices.Device;
import asd.homemaestro.Entities.Devices.DeviceCollection;
import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import asd.homemaestro.Entities.Residency.Home;
import asd.homemaestro.Entities.Rooms.Room;
import asd.homemaestro.HomeMaestroApplication;
import asd.homemaestro.mosquitto.MqttPublisher;
import asd.homemaestro.mosquitto.MqttSubscriber;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.io.IOException;

import static java.lang.Math.max;

public class HomeMaestroController {

    @FXML
    private ScrollPane roomContainer;

    private Home Home;

    private int size = 50;
    int layout = 25;
    int offset = 600;
    int offset2 = 150;

    private Font font = Font.font("Arial Black", 14);
    private Font fontTitle = Font.font("Arial Black", FontWeight.EXTRA_BOLD, 18);
    private Pane globalPane = new Pane();

    public  void setHome(Home home){
        this.Home = home;
    }

    @FXML
    public void addRooms() {
        int roomHeight = 0;
        for (Room room : Home.getRooms()
        ) {
            int sensorIndex = 0;
            int actuatorIndex = 0;
            Pane roomPane = CreateRoomPane(room.getName(), roomHeight);
            Pane sensorPane = CreateDevicePane(false);
            Pane actuatorPane = CreateDevicePane(true);
            for (DeviceCollection deviceCollection : room.getDeviceGroups()
            ) {
                for (Device device : deviceCollection.getDeviceList()) {
                    if (device instanceof Sensor) {
                        //Set Sensor Image
                        Image image = new Image(Consts.GetSensorImage(device.getClass().getSimpleName()));
                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(size);
                        imageView.setFitHeight(size);
                        Button imageButton = new Button();
                        imageButton.setGraphic(imageView);
                        imageButton.setLayoutX(layout);
                        imageButton.setLayoutY(layout + sensorIndex * offset2);
                        sensorPane.getChildren().addAll(imageButton);
                        //Set On/Off button
                        ToggleButton toggleButton = new ToggleButton("Off");
                        toggleButton.setLayoutX(layout + 15);
                        toggleButton.setLayoutY(layout * 4 + sensorIndex * offset2);
                        MqttSubscriber mqttSubscriber = new MqttSubscriber();
                        // Set Label to display readings
                        Label readingLabel = new Label(device.getState());
                        readingLabel.setLayoutX(offset - 200);
                        readingLabel.setLayoutY(imageButton.getLayoutY());
                        readingLabel.setPrefWidth(size * 4);
                        readingLabel.setPrefHeight(size);
                        readingLabel.setAlignment(Pos.CENTER);
                        sensorPane.getChildren().addAll(readingLabel);
                        //Set the On/Off button to start/close the mqtt connection
                        toggleButton.setOnAction(event -> {
                            try {
                                updateToggleButton(toggleButton, device, readingLabel, mqttSubscriber);
                            } catch (MqttException e) {
                                throw new RuntimeException(e);
                            }
                        });
                        sensorPane.getChildren().addAll(toggleButton);
                        // Set Label to display the device Name
                        Label deviceNamelabel = new Label();
                        deviceNamelabel.setText(device.getName());
                        deviceNamelabel.setLayoutX(imageButton.getLayoutX() + layout * 4);
                        deviceNamelabel.setLayoutY(imageButton.getLayoutY());
                        deviceNamelabel.setPrefWidth(size * 4);
                        deviceNamelabel.setPrefHeight(size);
                        deviceNamelabel.setAlignment(Pos.BASELINE_LEFT);
                        deviceNamelabel.setFont(font);
                        sensorPane.getChildren().addAll(deviceNamelabel);
                        sensorIndex++;
                    }else if(device instanceof Actuator){
                        Image image = new Image(Consts.GetActuatorImage(device.getClass().getSimpleName()));
                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(size);
                        imageView.setFitHeight(size);
                        Button imageButton = new Button();
                        imageButton.setGraphic(imageView);
                        imageButton.setLayoutX(layout);
                        imageButton.setLayoutY(layout + actuatorIndex * offset2);
                        actuatorPane.getChildren().addAll(imageButton);
                        actuatorIndex++;
                        // Set Label to display the Actuator Name
                        Label actuatorNamelabel = new Label();
                        actuatorNamelabel.setText(device.getName());
                        actuatorNamelabel.setLayoutX(imageButton.getLayoutX() + layout * 4);
                        actuatorNamelabel.setLayoutY(imageButton.getLayoutY());
                        actuatorNamelabel.setPrefWidth(size * 4);
                        actuatorNamelabel.setPrefHeight(size);
                        actuatorNamelabel.setAlignment(Pos.BASELINE_LEFT);
                        actuatorNamelabel.setFont(font);
                        actuatorPane.getChildren().addAll(actuatorNamelabel);
                        // Set Label to display Actuator state
                        Label stateLabel = new Label(device.getState());
                        stateLabel.setLayoutX(offset - 200);
                        stateLabel.setLayoutY(imageButton.getLayoutY());
                        stateLabel.setPrefWidth(size * 4);
                        stateLabel.setPrefHeight(size);
                        stateLabel.setAlignment(Pos.CENTER);
                        actuatorPane.getChildren().addAll(stateLabel);
                    }
                }
            }
            int indexMax = max(sensorIndex, actuatorIndex);
            if(indexMax == 0){
                indexMax = 1;
            }
            sensorPane.setPrefHeight(offset2 * indexMax);
            actuatorPane.setPrefHeight(offset2 * indexMax);
            roomPane.setPrefHeight(layout * 3 + offset2 * indexMax);
            roomPane.getChildren().addAll(sensorPane);
            roomPane.getChildren().addAll(actuatorPane);
            roomPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            sensorPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            actuatorPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            roomHeight = roomHeight +  (int)roomPane.getPrefHeight() + layout;
            globalPane.getChildren().addAll(roomPane);
        }
        roomContainer.setContent(globalPane);
        roomContainer.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        roomContainer.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        roomContainer.setStyle("-fx-background-color: transparent;");
    }

    private Pane CreateRoomPane(String roomName, int roomHeight) {
        Pane roomPane = new Pane();
        roomPane.setPrefWidth(offset * 2);
        roomPane.setLayoutY(roomHeight);
        Label roomNameLabel = new Label(roomName);
        roomNameLabel.setLayoutX(layout);
        roomNameLabel.setLayoutY(layout / 2);
        roomNameLabel.setFont(fontTitle);
        Label sensorTitleLabel = new Label("Sensors");
        sensorTitleLabel.setLayoutX(layout);
        sensorTitleLabel.setLayoutY(layout * 2);
        sensorTitleLabel.setFont(font);
        Label actuatorTitleLabel = new Label("Actuators");
        actuatorTitleLabel.setLayoutX(layout + offset);
        actuatorTitleLabel.setLayoutY(layout * 2);
        actuatorTitleLabel.setFont(font);
        roomPane.getChildren().addAll(roomNameLabel);
        roomPane.getChildren().addAll(sensorTitleLabel);
        roomPane.getChildren().addAll(actuatorTitleLabel);
        return roomPane;
    }

    private Pane CreateDevicePane(Boolean isActuator) {
        Pane devicePane = new Pane();
        devicePane.setPrefWidth(offset);
        devicePane.setLayoutY(layout * 3);
        if(isActuator) {
            devicePane.setLayoutX(offset);
        }
        return devicePane;
    }

    private void updateToggleButton(ToggleButton toggleButton, Device device, Label label, MqttSubscriber mqttSubscriber) throws MqttException {
        if (toggleButton.isSelected()) {
            toggleButton.setText(Consts.STATE_ON);
            manageConnection(device, true, label, mqttSubscriber);
        } else {
            toggleButton.setText(Consts.STATE_OFF);
            manageConnection(device, false, label, mqttSubscriber);
        }
    }

    private void manageConnection(Device device, Boolean on, Label label, MqttSubscriber mqttSubscriber) throws MqttException {
        if(on){
            String sensorConnectionString = Consts.GetSensorConnectionString(device.getId());
            mqttSubscriber.subscribeToTopic(sensorConnectionString, (topic, message) -> {
                String receivedMessage = new String(message.getPayload());
                Platform.runLater(() -> {
                    if(!receivedMessage.equalsIgnoreCase(Consts.SENSORCONNECTIONTURNON)){
                        device.setState(receivedMessage);
                        label.setText(device.getState());
                    }
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
            Platform.runLater(() -> {
                    device.setState(Consts.STATE_OFF);
                    label.setText(device.getState());
            });
        }
    }

    //CHANGE SCENE
    public void moveToRoom(ActionEvent event, Room room) throws IOException {
        FXMLLoader loader = new FXMLLoader(HomeMaestroApplication.class.getResource(Consts.ROOM_FXML));
        Parent root = loader.load();
        RoomViewController roomViewController = loader.getController();
        roomViewController.setRoom(room);
        roomViewController.addDevices();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}