package asd.virtualdevices.Services.Factories;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.virtualdevices.Entities.Sensor;
import asd.Utils.SensorType;
import asd.virtualdevices.Entities.TemperatureSensor;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SensorFactory {

    public static List<Sensor> GetSensorList(){
        List<Sensor> sensorList = new ArrayList<>();
        JSONArray sensorJson = JsonReader.ReadJson(Consts.DEVICES_FILE_NAME);
        for(int i = 0; i < sensorJson.length(); i++){
            var jsonObject = sensorJson.getJSONObject(i);
            if(jsonObject.get(Consts.JSONDEVICETYPE).toString().equalsIgnoreCase(Sensor.class.getSimpleName()) ) {
                Sensor sensor = SensorFactory.CreateSensor(jsonObject);
                sensorList.add(sensor);
            }
        }
        return sensorList;
    }

    public static Sensor CreateSensor(JSONObject jsonObject){
        Sensor sensor = null;
        Gson gson = new Gson();
        if(jsonObject.get(Consts.JSONTYPE).toString().equalsIgnoreCase(TemperatureSensor.class.getSimpleName()) ){
            sensor = gson.fromJson(jsonObject.toString(), TemperatureSensor.class);
        }
        return sensor;
    }
}
