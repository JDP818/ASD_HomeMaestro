package asd.homemaestro.Entities.Devices.Actuators;

public class Blinds extends Actuator{

    public Blinds(String Id, String Name, String State) {
        super(Id, Name, State);
    }

    @Override
    public String getState() {
        try {
            int lightIntensity = Integer.parseInt(super.getState());
            if (lightIntensity == 0) {
                return "Down"; // Night, so blinds are down
            } else if (lightIntensity == 1) {
                return "Up"; // Morning, so blinds are up
            } else if (lightIntensity == 2) {
                return "Halfway"; // Intermediary light, blinds are halfway down
            } else {
                return "Unknown"; // Handle other cases as needed
            }
        } catch (Exception e) {
            return "Unknown"; // Handle parsing errors
        }
    }
}
