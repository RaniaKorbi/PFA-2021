package com.jobOffers.recruitment.service;

import com.jobOffers.recruitment.exceptions.UserNotFoundException;


import com.jobOffers.recruitment.exceptions.UserNotFoundException;
import com.jobOffers.recruitment.model.User;


import com.jobOffers.recruitment.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User addUser(User user) {

        return userDao.save(user);
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public User updateUser(User user) {
        return userDao.save(user);
    }

    public User findUserById(Long id) {
        return userDao.findUserById(id).orElseThrow(() -> new UserNotFoundException("user not found"));
    }

    public void deleteUser(String email) {
        userDao.deleteUserByEmail(email);

    }


    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("user not found"));
    }
}




