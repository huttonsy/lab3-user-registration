package com.elkabani.userregistration;

public class Main {
    public static void main(String[] args) {
        UserRepository repo = new InMemoryUserRepository();
        NotificationService notifier = new EmailNotificationService();
        UserService service = new UserService(repo, notifier);

        // Register two different users
        User user1 = new User(1L, "Alice", "alice@example.com", "password1");
        User user2 = new User(2L, "Bob", "bob@example.com", "password2");

        service.registerUser(user1);
        service.registerUser(user2);

        // Attempt duplicate registration
        service.registerUser(user1);
    }
}
