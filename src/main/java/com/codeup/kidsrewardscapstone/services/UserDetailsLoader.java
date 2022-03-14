package com.codeup.kidsrewardscapstone.services;

import com.codeup.kidsrewardscapstone.models.User;
import com.codeup.kidsrewardscapstone.models.UserWithRoles;
import com.codeup.kidsrewardscapstone.repositories.RolesRepository;
import com.codeup.kidsrewardscapstone.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository users;
    private final RolesRepository roles;



    public UserDetailsLoader(UserRepository users, RolesRepository roles){
        this.users = users;
        this.roles = roles;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserWithRoles(user);
    }
}
