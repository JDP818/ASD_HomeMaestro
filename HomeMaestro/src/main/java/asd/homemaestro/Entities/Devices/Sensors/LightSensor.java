package asd.homemaestro.Entities.Devices.Sensors;

import asd.Utils.Consts;
import asd.homemaestro.Entities.Triggers.Trigger;

import java.util.List;

public class LightSensor extends Sensor {


    public LightSensor(String id, String name, String State, List<Trigger> triggerList) {
        super(id, name, State, triggerList);
    }

    @Override
    public void CreateReading() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getState() {
        try {
            int stateValue = Integer.parseInt(super.getState());
            if (stateValue == 0) {
                return "Night"; // Custom state indicating night
            } else if (stateValue == 1) {
                return "Morning"; // Custom state indicating morning
            } else if (stateValue == 2) {
                return "Intermediary"; // Custom state indicating intermediary light
            } else {
                return Consts.STATE_OFF; // Default state
            }
        } catch (NumberFormatException e) {
            return Consts.STATE_OFF; // Default state for non-integer values
        }
    }
}