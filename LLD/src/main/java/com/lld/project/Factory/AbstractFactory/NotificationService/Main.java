package com.lld.project.Factory.AbstractFactory.NotificationService;

public class Main {
    public static void main(String[] args) {
        NotificationFactoryRegistry registry = new NotificationFactoryRegistry();

        NotificationService emailService = new NotificationService(registry.get("EMAIL"));
        emailService.notify("alice@example.com", "Your order has shipped!");
        emailService.checkDelivery("MSG-001");

        System.out.println();

        NotificationService smsService = new NotificationService(registry.get("SMS"));
        smsService.notify("+91-9876543210", "OTP: 482910");
        smsService.checkDelivery("MSG-002");
    }
}
