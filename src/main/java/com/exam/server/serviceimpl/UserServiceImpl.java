package com.exam.server.serviceimpl;

import com.exam.server.entity.User;
import com.exam.server.entity.UserRole;
import com.exam.server.repository.RoleRepository;
import com.exam.server.repository.UserRepository;
import com.exam.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    //Creating the user
    @Override
    public User createUser(User user, Set<UserRole> userRole) throws Exception {

        User local = this.userRepository.findByUserName(user.getUserName());
        if (local != null) {
            System.out.println("User already exists !! ");
            throw new Exception("User already exists !!");

        } else {

            //it will create the user
            for (UserRole ur : userRole) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoleSet().addAll(userRole);
            local = this.userRepository.save(user);
        }
        return local;
    }
}
