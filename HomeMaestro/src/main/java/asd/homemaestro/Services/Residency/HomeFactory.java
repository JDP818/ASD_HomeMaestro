package asd.homemaestro.Services.Residency;

import asd.Utils.Consts;
import asd.homemaestro.Entities.Residency.Home;
import asd.homemaestro.Services.Rooms.RoomServices;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

public class HomeFactory {
    public static Home CreateHome(JSONArray homeArray){
        if(homeArray.isEmpty()){
            //Throw exception
        }
        var jsonObject = homeArray.getJSONObject(Consts.FIRST);
        Home home = CreateHomeFromJsonObject(jsonObject);
        home.setRooms(RoomServices.getRooms(true));
        return home;
    }

    private static Home CreateHomeFromJsonObject(JSONObject jsonObject){
        Gson gson = new Gson();
        return gson.fromJson(jsonObject.toString(), Home.class);
    }
}
