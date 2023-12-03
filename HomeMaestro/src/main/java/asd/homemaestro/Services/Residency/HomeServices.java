package asd.homemaestro.Services.Residency;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.homemaestro.Entities.Residency.Home;
import org.json.JSONArray;

public class HomeServices {
    public static Home getHome(){
        JSONArray homeJson = JsonReader.ReadJson(Consts.HOME_FILE_NAME);
        Home home = null;
        if(!homeJson.isEmpty()){
            home = HomeFactory.CreateHome(homeJson);
        }
        return home;
    }

    public static void addHome(){
        throw new UnsupportedOperationException();
    }

    public static void updateHome(){
        throw new UnsupportedOperationException();
    }
}
