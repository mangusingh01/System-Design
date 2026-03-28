import Abstraction.DataExporter.ExportPipeline;
import Abstraction.DataExporter.Impl.JSONFormatter;
import Abstraction.DataExporter.Impl.MockDBSource;
import Abstraction.DataExporter.Impl.StdoutWriter;
import Encapsulation.BankAccount.BankAccount;
import Encapsulation.TempratureSensor.TemperatureSensor;
import Encapsulation.UserAccount.UserAccount;
import Inheritance.StaffRoles.EmployeeRole;
import Inheritance.StaffRoles.ManagerRole;
import Inheritance.StaffRoles.Person;
import Polymorphism.OverloadingCompileTime.ReportFormatter;
import Polymorphism.OverridingRuntime.Document;
import Polymorphism.OverridingRuntime.DocumentRenderer;
import Polymorphism.OverridingRuntime.HTMLDocument;
import Polymorphism.OverridingRuntime.PDFDocument;

import java.util.List;
import java.util.Map;

public static void main(String[] args) {
    System.out.println("Starting with Encapsulation practice.....");

    System.out.println("#################  TemperatureSensor   ################# ");

    TemperatureSensor tempratureSensor1 = new TemperatureSensor(-400);

    TemperatureSensor tempratureSensor2 = new TemperatureSensor(3);

    System.out.println(tempratureSensor2.getTemperature());
    System.out.println(tempratureSensor2.getFahrenheit());

    System.out.println("################# User Account ################# ");

    UserAccount userAccount1 = new UserAccount("failedAttempt", "password");

    UserAccount userAccount2 = new UserAccount("mangu@gmail.com", "password");

    System.out.println(userAccount2.checkPassword("password"));
    System.out.println(userAccount2.checkPassword("wrongPassword"));
    System.out.println(userAccount2.checkPassword("wrongPassword"));
    System.out.println(userAccount2.checkPassword("wrongPassword"));
    System.out.println(userAccount2.checkPassword("wrongPassword"));
    System.out.println(userAccount2.checkPassword("wrongPassword"));

    System.out.println("################# Bank Account ################# ");

    BankAccount bankAccount = new BankAccount("Mangu", 1000);

    bankAccount.withdraw(1000);
    bankAccount.deposit(11000);
    bankAccount.withdraw(9000);

    System.out.println(bankAccount.getBalance());
    System.out.println(bankAccount.getHistory());

    bankAccount.freeze();
    bankAccount.deposit(11000);


    System.out.println("Starting with Abstraction practice.....");

    System.out.println("################# Data Exporter ################# ");

    new ExportPipeline(new MockDBSource(), new JSONFormatter(), new StdoutWriter()).run();

    System.out.println("Starting with Inheritance practice.....");
    System.out.println("################# Employee - Person ################# ");

    // Part-time employee who is also a manager — one Person, two roles
    Person mangu = new Person("Mangu Singh")
            .addRole(new EmployeeRole(120000, true))
            .addRole(new ManagerRole(6));

    System.out.println(mangu.describe());

    System.out.println("Starting with Polymorphism practice.....");
    System.out.println("################# Overloading - Report Generator ################# ");
    ReportFormatter fmt = new ReportFormatter();

    // Compiler resolves each call at compile time — no runtime cost
    System.out.println(fmt.format("Order #1042"));
    System.out.println(fmt.format(List.of("Alice", "Bob", "Priya")));
    System.out.println(fmt.format(Map.of("Status", "Shipped", "ETA", "2 days")));
    System.out.println(fmt.format("Team", List.of("Alice", "Bob")));

    System.out.println("################# Overriding - Document Renderer ################# ");
    List<Document> docs = List.of(
            new PDFDocument("Annual Report", "Finance"),
            new HTMLDocument("Product Page", "Marketing")
    );
    new DocumentRenderer().renderAll(docs);
}
