package com.exam.server.service;

import com.exam.server.entity.User;
import com.exam.server.entity.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRole) throws Exception;
}
