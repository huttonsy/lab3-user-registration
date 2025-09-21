package com.elkabani.userregistration;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {
        if (userRepository.exists(user.getEmail())) {
            System.out.println("❌ Registration failed: User with email " + user.getEmail() + " already exists.");
            return;
        }
        userRepository.save(user);
        notificationService.sendNotification(
                user.getEmail(),
                "✅ Registration successful for " + user.getName() + "!"
        );
    }
}
