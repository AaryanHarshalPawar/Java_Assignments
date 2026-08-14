package Assignment_11;

public class SwitchableDemo {
    interface Switchable {
        void turnOn();
    }

    static class Light implements Switchable {
        String location;
        int wattage;

        Light(String location, int wattage) {
            this.location = location;
            this.wattage = wattage;
        }

        public void turnOn() {
            System.out.println("Device: Light");
            System.out.println("Location: " + location);
            System.out.println("Wattage: " + wattage + "W");
            System.out.println("Status: Light is ON");
        }
    }

    static class Fan implements Switchable {
        String location;
        int speedLevel;

        Fan(String location, int speedLevel) {
            this.location = location;
            this.speedLevel = speedLevel;
        }

        public void turnOn() {
            System.out.println("Device: Fan");
            System.out.println("Location: " + location);
            System.out.println("Speed Level: " + speedLevel);
            System.out.println("Status: Fan is ON");
        }
    }

    public static void main(String[] args) {
        Switchable light = new Light("Study Room", 15);
        Switchable fan = new Fan("Bedroom", 3);

        System.out.println("Device Status");
        System.out.println("=============");

        light.turnOn();
        System.out.println();
        fan.turnOn();
    }
}
