package com.apigateway.azure.springjwt.service;

import com.apigateway.azure.springjwt.data.UserData;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserData user = findUser(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }

        return new User(user.getUserName(), user.getUserPassword(), Collections.emptyList());
    }

    private UserData findUser(String userName) {

        UserData user = new UserData();
        user.setUserName("admin");
        user.setUserPassword(bCryptPasswordEncoder.encode("nimda"));

        return user;
    }

    public List<UserData> listUsers() {

        ArrayList<UserData> list = new ArrayList<>();
        list.add(findUser("admin"));
        return list;
    }
}
