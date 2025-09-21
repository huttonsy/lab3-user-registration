package com.elkabani.userregistration;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
    boolean exists(String email);
}
