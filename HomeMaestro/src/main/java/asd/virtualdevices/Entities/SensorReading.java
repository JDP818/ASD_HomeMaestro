package asd.virtualdevices.Entities;

import java.time.LocalDateTime;

public class SensorReading {
    private  String mesurement;
    private int value;
    private LocalDateTime date;

    public SensorReading(String mesurement, int value){
        this.mesurement = mesurement;
        this.value = value;
        this.date = LocalDateTime.now();
    }

    public SensorReading(int value){
        this.value = value;
        this.date = LocalDateTime.now();
    }

    public String toString(){
       // return id + "," + value + "," + date.toString();
        return String.valueOf(value);
    }
}
