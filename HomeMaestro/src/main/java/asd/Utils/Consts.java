package asd.Utils;

import asd.homemaestro.Entities.Rooms.RoomType;

public class Consts {
    //Values
    public static final int FIRST = 0;
    public static final String MEASUREMENT_TEMPERATURE_C = "°C";
    public static final String STATE_OFF = "Off";
    public static final String STATE_ON = "On";

    //Files
    public static final String HOMEMAESTRO_FXML = "hello-view.fxml";
    public static final String ROOM_FXML = "room-view.fxml";
    public static final String CREATE_HOME_FXML = "createHomeview.fxml";
    public static final String SENSOR_FILE_NAME = "src\\main\\java\\asd\\virtualdevices\\sensors.json";
    public static final String HOME_FILE_NAME = "src\\main\\java\\asd\\homemaestro\\Files\\home.json";
    public static final String ROOMS_FILE_NAME = "src\\main\\java\\asd\\homemaestro\\Files\\rooms.json";
    public static final String DEVICES_FILE_NAME = "src\\main\\java\\asd\\homemaestro\\Files\\devices.json";
    public static final String JSONID = "id";
    public static final String JSONTYPE = "Type";
    public static final String JSONDEVICETYPE = "DeviceType";
    public static final String JSONROOMID = "RoomId";

    //Mqtt connection
    public static final String SENSORDISCOVERY = "sensorDiscovery";
    public static final String SENSORCONNECTION = "sensorConnection";
    public static final String SENSORCONNECTIONTURNON = "sensorConnectionTurnOn";
    public static final String SENSORCONNECTIONTURNOFF = "sensorConnectionTurnOff";
    public static final String CONNECTIONSUCCESSFUL = "connectionSuccessful";
    public static final String CLOSECONNECTION = "closeConnection";

    //Room Images
    public static final String KITCHEN = "https://i.imgur.com/xIqX8O7.png";
    public static final String LIVINGROOM = "https://i.imgur.com/Kkgh5HR.png";
    public static final String DEFAULT = "https://i.imgur.com/ASQnH5h.png";

    //Sensor Images
    public static final String TERMOMETER = "https://i.imgur.com/J6xdV2C.png";
    public static final String TERMOMETERCOLD = "https://i.imgur.com/NLUNvF1.png";
    public static final String DEFAULTSENSOR = "https://i.imgur.com/zXPvkXJ.png";

    //Actuator Images
    public static final String AC = "https://i.imgur.com/3uMsv8d.png";


    public static String GetRoomImage(String roomName){

        switch (roomName.toUpperCase()){
            case "KITCHEN" -> {
                return KITCHEN;
            }
            case "LIVINGROOM" -> {
                return LIVINGROOM;
            }
            default -> {
                return DEFAULT;
            }
        }
    }

    public static String GetSensorImage(String sensorName){

        switch (sensorName.toUpperCase()){
            case "TEMPERATURESENSOR" -> {
                return TERMOMETER;
            }
            default -> {
                return DEFAULTSENSOR;
            }
        }
    }

    public static String GetActuatorImage(String actuatorName){

        switch (actuatorName.toUpperCase()){
            case "ACACTUATOR" -> {
                return AC;
            }
            default -> {
                return DEFAULTSENSOR;
            }
        }
    }
    public static String GetSensorConnectionString(String id){
        return SENSORCONNECTION + id;
    }
}
