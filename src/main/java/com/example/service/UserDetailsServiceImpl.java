package com.example.service;

import com.example.enums.UserRole;
import com.example.model.UserEntity;
import com.example.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


@Component
public class UserDetailsServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserDetailsServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    private static List<GrantedAuthority> buildSimpleGrantedAuthorities(final Set<UserRole> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            return new User(userEntity.getUsername(), userEntity.getPassword(), buildSimpleGrantedAuthorities(userEntity.getRoles()));
        } else {
            throw new UsernameNotFoundException("UserEntity not found with username: " + username);
        }
    }


    public Boolean addUser(UserEntity userEntity) {
        UserEntity userFromDB = userRepository.findByUsername(userEntity.getUsername());
        if (userFromDB != null) {
            return false;
        }
        userEntity.setUsername(userEntity.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles(Collections.singleton(UserRole.USER));
        userEntity.setFullName(userEntity.getFullName());
        userEntity.setActive(true);
        userRepository.save(userEntity);
        return true;
    }
}

