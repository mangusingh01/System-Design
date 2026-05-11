package com.lld.project.Practice.Library.Notify;

public class EmailNotifier implements NotificationListener {
    @Override
    public void onBookAvailable(String isbn, String memberId) {
        // In production: inject an EmailService
        System.out.printf("[EMAIL] Hey member %s — book %s is now available!%n",
                memberId, isbn);
    }
}
