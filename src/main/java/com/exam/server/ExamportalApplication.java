package com.exam.server;

import com.exam.server.entity.Role;
import com.exam.server.entity.User;
import com.exam.server.entity.UserRole;
import com.exam.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ExamportalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("This is starting ");

        User user = new User();
        user.setUserName("AAA");
        user.setAbout("java Developer");
        user.setEmail("akash.wagh22mare@gmail.com");
        user.setEnabled(true);
        user.setFirstName("Akash");
        user.setLastName("Waghmare");
        user.setMobileNo("8208550700");
        user.setPassword("12345");

        Role role1 = new Role();
        role1.setRoleName("Project Manager");

        Set<UserRole> userRole = new HashSet<UserRole>();
        UserRole ur = new UserRole();
        ur.setRole(role1);
        ur.setUser(user);
        userRole.add(ur);
        user.setUserRoleSet(userRole);
        User user1 = this.userService.createUser(user, userRole);
        System.out.println("This is user Name  " + user1.getUserName());
    }
}
