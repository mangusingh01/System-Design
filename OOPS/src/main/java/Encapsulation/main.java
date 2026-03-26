import Encapsulation.TempratureSensor.TemperatureSensor;

public static void main(String[] args) {

    System.out.println("TemperatureSensor.........");

    TemperatureSensor tempratureSensor1 = new TemperatureSensor(-400);

    TemperatureSensor tempratureSensor2 = new TemperatureSensor(3);

    System.out.println(tempratureSensor2.getTemperature());
    System.out.println(tempratureSensor2.getFahrenheit());

    System.out.println("User Account ..........");
}