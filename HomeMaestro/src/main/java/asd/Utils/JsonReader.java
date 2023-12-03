package asd.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;


public class JsonReader {
    public static JSONArray ReadJson(String fileName){
        JSONArray jsonArray = new JSONArray();
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(fileName)));
            jsonArray = new JSONArray(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
