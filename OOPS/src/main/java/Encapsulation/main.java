import Encapsulation.TempratureSensor.TemperatureSensor;
import Encapsulation.UserAccount.UserAccount;

public static void main(String[] args) {

    System.out.println("TemperatureSensor.........");

    TemperatureSensor tempratureSensor1 = new TemperatureSensor(-400);

    TemperatureSensor tempratureSensor2 = new TemperatureSensor(3);

    System.out.println(tempratureSensor2.getTemperature());
    System.out.println(tempratureSensor2.getFahrenheit());

    System.out.println("User Account ..........");

    UserAccount userAccount1 = new UserAccount("failedAttempt", "password");

    UserAccount userAccount2 = new UserAccount("mangu@gmail.com", "password");

    System.out.println(userAccount2.checkPassword("password"));
    System.out.println(userAccount2.checkPassword("wrongPassword"));
    System.out.println(userAccount2.checkPassword("wrongPassword"));
    System.out.println(userAccount2.checkPassword("wrongPassword"));
    System.out.println(userAccount2.checkPassword("wrongPassword"));
    System.out.println(userAccount2.checkPassword("wrongPassword"));


}